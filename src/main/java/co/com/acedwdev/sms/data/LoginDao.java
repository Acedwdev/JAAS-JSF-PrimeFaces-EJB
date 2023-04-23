
package co.com.acedwdev.sms.data;

import co.com.acedwdev.sms.domain.Login;
import java.util.List;

public interface LoginDao {
    public List<Login> findAllLogins();
    
    public Login findLoginById(Login login);  
        
    public void insertLogin(Login user);
    
    public void updateLogin(Login user);
    
    public void deleteLogin(Login user);
}
