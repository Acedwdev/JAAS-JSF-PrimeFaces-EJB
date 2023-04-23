
package co.com.acedwdev.sms.service;

import co.com.acedwdev.sms.domain.Login;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface ServiceLogin {
    public List<Login> loginList();
    
    public Login findLoginById(Login login);   
    
    public void registerLogin(Login login);
    
    public void modifyLogin(Login login);
    
    public void deleteLogin(Login login);
}
