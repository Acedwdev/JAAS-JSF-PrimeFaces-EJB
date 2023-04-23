
package co.com.acedwdev.sms.data;

import co.com.acedwdev.sms.domain.Login;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LoginDaoImpl implements LoginDao{
    
    @PersistenceContext(unitName="SmsPU")
    EntityManager em;

    @Override
    public List<Login> findAllLogins() {
        return em.createNamedQuery("Login.findAll").getResultList();
    }

    @Override
    public Login findLoginById(Login login) {
        return em.find(Login.class, login.getIdLogin());
    }

    @Override
    public void insertLogin(Login login) {
    }

    @Override
    public void updateLogin(Login login) {
    }

    @Override
    public void deleteLogin(Login login) {
    }
    
}
