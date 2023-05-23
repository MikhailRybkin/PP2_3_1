package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> index();

    void deleteUserById(Long id);

    void saveUser(User user);

    void updateUser(User user, Long id);

    User showById(Long id);
}
