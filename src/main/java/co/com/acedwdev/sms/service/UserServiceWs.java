
package co.com.acedwdev.sms.service;

import co.com.acedwdev.sms.domain.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface UserServiceWs {
    
    @WebMethod
    public List<User> userList();
}
