
package co.com.acedwdev.sms.customer.lifeciclejpa;

import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PersistObjectJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        User user1 = new User("Phil", "Jones", "pjones@mail.com", "651598566");
        
        tx.begin();
        
        em.persist( user1 );
        
        log.debug("Persist object - no commit:" + user1);
        
        tx.commit();
        
        log.debug("Persist object - detached state:" + user1);
        
        em.close();
    }
}
