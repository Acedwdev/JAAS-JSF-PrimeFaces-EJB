
package co.com.acedwdev.sms.data;

import co.com.acedwdev.sms.domain.User;
import java.util.List;

public interface UserDao {
    public List<User> findAllUsers();
    
    public User findUserById(User user);
    
    public User findUserByEmail(User user);
    
    public void insertUser(User user);
    
    public void updateUser(User user);
    
    public void deleteUser(User user);
}
