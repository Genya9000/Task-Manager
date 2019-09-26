package ml.khaliman.dao;

import ml.khaliman.model.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User findOne(String login1) {
        return  entityManager.find(User.class, login1);
    }

    @Override
    public List<User> list() {
        Query query = entityManager.createNativeQuery("SELECT * FROM users ");
        return query.getResultList();
    }
}
