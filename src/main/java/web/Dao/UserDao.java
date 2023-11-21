package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    void deleteUserById(Long id);

    User getUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);
}


