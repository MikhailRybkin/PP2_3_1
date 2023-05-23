package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> index();

    void deleteUserById(Long id);

    void saveUser(User user);

    void updateUser(User user, Long id);

    User showById(Long id);
}

