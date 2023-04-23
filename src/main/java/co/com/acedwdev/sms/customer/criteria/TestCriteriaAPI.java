
package co.com.acedwdev.sms.customer.criteria;

import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.*;


public class TestCriteriaAPI {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder cb = null;
        CriteriaQuery<User> criteriaQuery = null;
        Root<User> fromUser = null;
        TypedQuery<User> query = null;
        User user = null;
        List<User> users = null;
        
        cb = em.getCriteriaBuilder();
        
        criteriaQuery = cb.createQuery(User.class);
        
        fromUser = criteriaQuery.from(User.class);
        
        criteriaQuery.select(fromUser);
        
        query = em.createQuery(criteriaQuery);
        
        users = query.getResultList();
        
        //showUsers(users);     
        
        //jpql = "select u from User u where u.idUser = 1"
        /*log.debug("\n2-a. User query with id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(User.class);
        fromUser = criteriaQuery.from(User.class);
        criteriaQuery.select(fromUser).where(cb.equal(fromUser.get("idUser"), 1));
        user = em.createQuery(criteriaQuery).getSingleResult();
        log.debug(user);*/
        
        log.debug("\n2-b. User query with id = 1");
        cb = em.getCriteriaBuilder();
        criteriaQuery = cb.createQuery(User.class);
        fromUser = criteriaQuery.from(User.class);
        criteriaQuery.select(fromUser);
        
        List<Predicate> criteria = new ArrayList<Predicate>();
        
        Integer idUserParam = 1;
        ParameterExpression<Integer> parameter = cb.parameter(Integer.class, "idUser");
        criteria.add( cb.equal(fromUser.get("idUser"), parameter));
        
        if(criteria.isEmpty()){
            throw new RuntimeException("No criteria");
        }
        else if(criteria.size() == 1){
            criteriaQuery.where(criteria.get(0));
        }
        else{
            criteriaQuery.where(cb.and(criteria.toArray(new Predicate[0])));
        }
        
        query = em.createQuery(criteriaQuery);
        query.setParameter("idUser", idUserParam);
        
        user = query.getSingleResult();
        log.debug(user);        
        
    }
    
    private static void showUsers(List<User> users) {
        for(User u: users){
            log.debug(u);
        }
    }
}
