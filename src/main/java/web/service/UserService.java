package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> readUsers();
    User getUser(long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser (long user);
}
