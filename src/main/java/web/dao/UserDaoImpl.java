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

    EntityManager em;

    public UserDaoImpl() {
    }
    @Autowired
    public UserDaoImpl(EntityManagerFactory emf) {
        this.em = emf.createEntityManager();
    }

    @Override
    public List<User> getUsers() {
        List<User> users = (em.createQuery("select u from User u").getResultList());
        return users;
    }

    @Override
    public User getUserById(long id) {
        User user = em.find(User.class, id);
        return (user);
    }

    @Override
    public void saveUser(User user) {

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void updateUser(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void deleteUser(long id) {
        em.getTransaction().begin();
        em.remove(em.find(User.class, id));
        em.getTransaction().commit();
    }
}
