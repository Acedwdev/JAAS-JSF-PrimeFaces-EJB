
package co.com.acedwdev.sms.service;

import co.com.acedwdev.sms.data.LoginDao;
import co.com.acedwdev.sms.domain.Login;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ImplServiceLogin implements RemoteServiceLogin, ServiceLogin{
    
    @Inject
    private LoginDao loginDao;

    @Override
    public List<Login> loginList() {
        return loginDao.findAllLogins();
    }

    @Override
    public Login findLoginById(Login login) {
        return loginDao.findLoginById(login);
    }

    @Override
    public void registerLogin(Login login) {
        loginDao.insertLogin(login);
    }

    @Override
    public void modifyLogin(Login login) {
        loginDao.updateLogin(login);
    }

    @Override
    public void deleteLogin(Login login) {
        loginDao.deleteLogin(login);
    }   
    
}
