
package co.com.acedwdev.sms.service;

import co.com.acedwdev.sms.domain.User;
import jakarta.ejb.Remote;
import java.util.List;

@Remote
public interface RemoteServiceUser {
    public List<User> userList();
    
    public User findUserById(User user);
    
    public User findUserByEmail(User user);
    
    public void registerUser(User user);
    
    public void modifyUser(User user);
    
    public void deleteUser(User user);
}
