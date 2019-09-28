package ml.khaliman.dao;

import ml.khaliman.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

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
        try {
            User user = (User) entityManager.createQuery("SELECT user FROM User user WHERE user.login =?1")
                    .setParameter(1, login1).getSingleResult();
            return user;
        }
        catch (NoResultException ex) {
            System.out.println("Client not found!"); return null;}
        catch (NonUniqueResultException ex) {
            System.out.println("Non unique result!");
            return null;
        }
    }

    @Override
    public List<User> list() {
        Query query = entityManager.createNativeQuery("SELECT * FROM users ");
        return query.getResultList();
    }
}
