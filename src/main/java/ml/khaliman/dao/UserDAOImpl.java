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
    public User findOne(long id) {
        return entityManager.getReference(User.class, id);
    }

    @Override
    public List<User> list() {
        Query query = entityManager.createNativeQuery("SELECT * FROM users ");
        return query.getResultList();
    }
}
