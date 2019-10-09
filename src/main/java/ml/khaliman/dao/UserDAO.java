package ml.khaliman.dao;
import ml.khaliman.model.User;

import java.util.List;

public interface UserDAO {
    void add(User user);

    void delete(User user);

    Object findOne(String login);

    List<User> list();
}
