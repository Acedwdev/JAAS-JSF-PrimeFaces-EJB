
package co.com.acedwdev.sms.customer.association;

import co.com.acedwdev.sms.domain.Login;
import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CustomerAssociationJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        
        List<User> users = em.createNamedQuery("User.findAll").getResultList();        
        
        em.close();        
        
        for(User user : users){
            log.debug("User:" + user);            
            for(Login login: user.getLoginList()){
                log.debug("Login:" + login);
            }
        }
    }
}
