
package co.com.acedwdev.sms.customer.lifeciclejpa;

import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DeleteObjectJPA {
        static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();         
        tx.begin();       
                
        User user1 = em.find(User.class, 4);      
               
        tx.commit();    
               
        log.debug("Found object - detached state:" + user1);        
                
        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();
        
        em.remove(em.merge(user1));
        
        tx2.commit();
        
        log.debug("Delete object - detached state:" + user1);
        
        em.close();
    }
}
