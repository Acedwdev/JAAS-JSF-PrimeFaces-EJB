
package co.com.acedwdev.sms.customer.cascade;

import co.com.acedwdev.sms.domain.Login;
import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import org.apache.logging.log4j.*;


public class CascadePersistenceJPA {
     static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        User user1 = new User("Monica", "Brown", "mbrown@mail.com", "8566-5498");
        
        Login login1 = new Login("mbrown", "789", user1);
        
        em.persist(login1);
        
        tx.commit();
        
        log.debug("Persist object user:" + user1);
        log.debug("Persist object user:" + login1);
        
        em.close();
        
    }
}
