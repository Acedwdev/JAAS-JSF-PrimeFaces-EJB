
package co.com.acedwdev.sms.customer.lifeciclejpa;

import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class UpdateLargeSessionObject {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();       
                
        tx.begin();       
                
        User user1 = em.find(User.class, 1);       
                
        log.debug("Found object:" + user1);
        
        user1.setEmail("mmiller@mail.com");
        
        user1.setEmail("m.miller@mail.com");       
        
        tx.commit();
        
        log.debug("updated object - detached state:" + user1);
        
        em.close();
    }
}
