package pl.ksiegarnia.database;

import pl.ksiegarnia.model.User;

public interface IUserDao {

    User getUserByLogin(String login);
    void persistUser(User user);

}
