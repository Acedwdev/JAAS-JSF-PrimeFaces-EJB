package co.com.acwdedwv.sms.customer.jpql;

import co.com.acedwdev.sms.domain.Login;
import co.com.acedwdev.sms.domain.User;
import jakarta.persistence.*;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.*;

public class TestJPQL {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        String jpql = null;
        Query q = null;
        List<User> users = null;
        User user = null;
        Iterator iter = null;
        Object[] tupla = null;
        List<String> names = null;
        List<Login> logins = null;

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SmsPU");
        EntityManager em = emf.createEntityManager();

        //log.debug("\n1. Consultation of all Users");
        //jpql = "select u from User u";
        //users = em.createQuery(jpql).getResultList();
        //showUsers(users);
        
        //log.debug("\n2. Consultation User id = 1");
        //jpql = "select u from User u where u.idUser = 1";
        //user = (User) em.createQuery(jpql).getSingleResult();
        //log.debug(user);
        
        //jpql = "select u from User u where u.name = 'Jean'";
        //users = em.createQuery(jpql).getResultList();
        //showUsers(users);
        
        /*log.debug("\n4. Query individual data, an array (tupla) of type object with 3 colums is created");
        jpql = "select u.name as Name, u.lastName as LastName, u.email as Email from User u";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            String name = (String) tupla[0];
            String lastName = (String) tupla[1];
            String email = (String) tupla[2];
            log.debug("name:" + name + ", lastName:" + lastName + ", email:" + email) ;
        }*/
        
        /*log.debug("\n. Get Object User and id, an array of type object with 2 colums is created");
        jpql = "select u, u.idUser from User u ";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            user = (User) tupla[0];
            int idUser = (int) tupla[1];
            log.debug("User Object:" + user);
            log.debug("id user:" + idUser );
        }*/
        
        /*System.out.println("\n6. Query all users");
        jpql = "select new co.com.acedwdev.sms.domain.User( u.idUser ) from User u";
        users = em.createQuery(jpql).getResultList();
        showUsers(users);*/
        
        /*System.out.println("\n7. Returns the minimum and maximum value of the idPerson (scaler result)");
        jpql = "select min(u.idUser) as MinId, max(u.idUser) as MaxId, count(u.idUser) as Contador from User u";
        iter = em.createQuery(jpql).getResultList().iterator();
        while(iter.hasNext()){
            tupla = (Object[]) iter.next();
            Integer idMin = (Integer) tupla[0];
            Integer idMax = (Integer) tupla[1];
            Long count = (Long) tupla[2];
            log.debug("idMin:" + idMin + ", idMax:" + idMax + ", count:" + count);
        }*/
        
        /*log.debug("\n8. Count the names of users who are different");
        jpql = "select count(distinct u.name) from User u";
        Long counter = (Long) em.createQuery(jpql).getSingleResult();
        log.debug("Number of users with different names:" + counter);*/
        
        /*log.debug("\n9. Concatenates and uppercases first and last name");
        jpql = "select CONCAT(u.name, ' ', u.lastName) as Name from User u";
        names = em.createQuery(jpql).getResultList();
        for(String fullName: names){
            log.debug(fullName);
        }*/
        
        /*log.debug("\n10. Gets the user object with id equal to the provided parameter");
        int idUser = 5;
        jpql = "select u from User u where u.idUser = :id";
        q = em.createQuery(jpql);
        q.setParameter("id", idUser);
        user = (User) q.getSingleResult();
        log.debug(user);*/
        
        /*log.debug("\n11. Gets the user that contain a letter a in the name, regardless of whether it is uppercase or lowercase");
        jpql = "select u from User u where upper(u.name) like upper(:parameter)";
        String parameterString = "%a%";
        q = em.createQuery(jpql);
        q.setParameter("parameter", parameterString);
        users = q.getResultList();
        showUsers(users);*/
        
        /*log.debug("\n12. between");
        jpql = "select u from User u where u.idUser between 2 and 3";
        users = em.createQuery(jpql).getResultList();
        showUsers(users);*/
        
        /*log.debug("\n13. Ordering use");
        jpql = "select u from User u where u.idUser > 2 order by u.name desc, u.lastName desc";
        users = em.createQuery(jpql).getResultList();
        showUsers(users);*/
        
        /*log.debug("\n14.Subquery use");
        jpql = "select u from User u where u.idUser in (select min(u1.idUser) from User u1)";
        users = em.createQuery(jpql).getResultList();
        showUsers(users);*/
        
        log.debug("\n15. join use with lazy loading");
        jpql = "select l from Login l join l.user u";
        logins = em.createQuery(jpql).getResultList();
        showLogins(logins);
        
        log.debug("16. Left join use with eager loading");
        jpql = "select l from Login l left join fetch l.user";
        logins = em.createQuery(jpql).getResultList();
        showLogins(logins);
    }

    private static void showUsers(List<User> users) {
        for (User u : users) {
            log.debug(u);
        }
    }
    
    private static void showLogins(List<Login> logins) {
        for(Login l: logins){
            log.debug(l);
        }
    }
}
