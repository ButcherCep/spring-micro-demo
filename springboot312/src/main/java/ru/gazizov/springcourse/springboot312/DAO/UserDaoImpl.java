package ru.gazizov.springcourse.springboot312.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import ru.gazizov.springcourse.springboot312.model.User;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> showAllUsers() {
        TypedQuery<User> query= entityManager.createQuery("SELECT u FROM User u ", User.class);
        return query.getResultList();
    }
    @Override
    public User showUserId(int id) {
        return entityManager.find(User.class, Integer.valueOf(id));
    }
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }
    @Override
    public void updateUser(int id, User updateUser) {
        entityManager.merge(updateUser);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class, Integer.valueOf(id));
        entityManager.remove(user);
    }
}
