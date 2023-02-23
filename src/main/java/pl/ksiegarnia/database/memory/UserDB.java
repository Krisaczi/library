package pl.ksiegarnia.database.memory;

import org.springframework.stereotype.Component;
import pl.ksiegarnia.database.IUserDao;
import pl.ksiegarnia.exceptions.ExistingUserLoginException;
import pl.ksiegarnia.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDB implements IUserDao {

    private final List<User> users = new ArrayList<>();

    public UserDB() {
        this.users.add(new User(1,"Jan","Jankowski","jan123","0f33e4f69e126d2aab68a6e8adb1b909", User.Role.USER));
        this.users.add(new User(2,"Krzysztof","Mrozowski","admin","21232f297a57a5a743894a0e4a801fc3", User.Role.ADMIN));
    }

    @Override
    public User getUserByLogin(String login) {
        for(User user : this.users) {
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void persistUser(User user) {
        if(getUserByLogin(user.getLogin()) != null){
            throw new ExistingUserLoginException();
        }
        this.users.add(user);
    }
}
