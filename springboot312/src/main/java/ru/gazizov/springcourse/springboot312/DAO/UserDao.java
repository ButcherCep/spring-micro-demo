package ru.gazizov.springcourse.springboot312.DAO;

import ru.gazizov.springcourse.springboot312.model.User;
import java.util.List;

public interface UserDao {
    List<User> showAllUsers();

    User showUserId(int id);

    void saveUser(User user);

    void updateUser(int id, User updateuser);

    void deleteUser(int id);
}
