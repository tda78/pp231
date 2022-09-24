package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User(1l, "m", "m", (byte) 12));
        users.add(new User(2l, "a", "a", (byte) 123));
        users.add(new User(3l, "q", "q", (byte) 5));
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User getUserById(long id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        long id = user.getId();
        for (User tempUser : users
        ) {
            if (tempUser.getId() == id) {
                tempUser.setMail(user.getMail());
                tempUser.setPass(user.getPass());
                tempUser.setAge(user.getAge());
                return;
            }
        }
    }

    @Override
    public void deleteUser(long id) {
        for (User tempUser : users
        ) {
            if (tempUser.getId() == id) {
                users.remove(tempUser);
                return;
            }
        }
    }
}
