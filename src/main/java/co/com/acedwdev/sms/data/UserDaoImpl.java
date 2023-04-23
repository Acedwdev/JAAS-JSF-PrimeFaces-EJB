
package co.com.acedwdev.sms.data;

import co.com.acedwdev.sms.domain.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import java.util.List;

@Stateless
public class UserDaoImpl implements UserDao{
    
    @PersistenceContext(unitName="SmsPU")
    EntityManager em;

    @Override
    public List<User> findAllUsers() {
        return em.createNamedQuery("User.findAll").getResultList();
    }

    @Override
    public User findUserById(User user) {
        return em.find(User.class, user.getIdUser());
    }

    @Override
    public User findUserByEmail(User user) {
        Query query = em.createQuery("from User u where u.email =: email");
        query.setParameter("email", user.getEmail());
        return (User) query.getSingleResult();
    }

    @Override
    public void insertUser(User user) {
        em.persist(user);
    }

    @Override
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        em.remove(em.merge(user));
    }
}
