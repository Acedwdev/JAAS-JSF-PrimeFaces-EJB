package co.com.acedwdev.sms.service;

import co.com.acedwdev.sms.data.UserDao;
import co.com.acedwdev.sms.domain.User;
import jakarta.annotation.Resource;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import java.util.List;

@Stateless
@WebService(endpointInterface = "co.com.acedwdev.sms.service.UserServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class ImplServiceUser implements RemoteServiceUser, ServiceUser, UserServiceWs {

    @Inject
    private UserDao userDao;

    @Resource
    private SessionContext context;

    @Override
    public List<User> userList() {
        return userDao.findAllUsers();
    }

    @Override
    public User findUserById(User user) {
        return userDao.findUserById(user);
    }

    @Override
    public User findUserByEmail(User user) {
        return userDao.findUserByEmail(user);
    }

    @Override
    public void registerUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void modifyUser(User user) {
        try {
            userDao.updateUser(user);
        } catch (Throwable t) {
            context.setRollbackOnly();
            t.printStackTrace(System.out);
        }

    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

}
