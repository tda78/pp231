package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private List<User> users = new ArrayList<>();

    EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UserDaoImpl() {
        users.add(new User(1l, "m", "m", (byte) 12));
        users.add(new User(2l, "a", "a", (byte) 123));
        users.add(new User(3l, "q", "q", (byte) 5));
    }

    @Override
    public List<User> getUsers() {
        EntityManager em = emf.createEntityManager();
        List<User> users = (em.createQuery("select u from User u").getResultList());
        em.close();
        return users;
    }

    @Override
    public User getUserById(long id) {
        EntityManager entityManager = emf.createEntityManager();
        User user = entityManager.find(User.class, id);
        entityManager.close();
        return (user);
    }

    @Override
    public void saveUser(User user) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void updateUser(User user) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(user);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public void deleteUser(long id) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(manager.find(User.class, id));
        manager.getTransaction().commit();
        manager.close();
    }
}
