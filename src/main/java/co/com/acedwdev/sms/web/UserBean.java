package co.com.acedwdev.sms.web;

import co.com.acedwdev.sms.domain.User;
import co.com.acedwdev.sms.service.ServiceUser;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;
import org.apache.logging.log4j.*;
import org.primefaces.event.RowEditEvent;

@Named("userBean")
@RequestScoped
public class UserBean {

    Logger log = LogManager.getRootLogger();

    @Inject
    private ServiceUser serviceUser;

    private User selectedUser;

    List<User> users;

    public UserBean() {
        log.debug("Starting UserBean object");
    }

    @PostConstruct
    public void initialize() {
        this.users = serviceUser.userList();
        log.debug("Found Users in ManagedBean:" + this.users);
        this.selectedUser = new User();
    }

    public void editListener(RowEditEvent event) {
        User user = (User) event.getObject();
        serviceUser.modifyUser(user);
    }

    public User getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(User selectedUser) {
        this.selectedUser = selectedUser;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser() {
        this.serviceUser.registerUser(selectedUser);
        this.users.add(selectedUser);
        this.selectedUser = null;
    }
    
    public void deleteUser(){
        this.serviceUser.deleteUser(selectedUser);
        this.users.remove(this.selectedUser);
        this.selectedUser = null;
    }
    
    public void restartSelectedUser(){
        this.selectedUser = new User();
    }
}
