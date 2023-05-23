package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("FROM User", User.class)
                .getResultList();
    }

    @Override
    public void deleteUserById(Long id) {
        User userToDelete = entityManager.find(User.class, id);
        entityManager.remove(userToDelete);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user , Long id) {
        entityManager.merge(user);
    }

    @Override
    public User showById(Long id) {
        return entityManager.find(User.class, id);
    }
}