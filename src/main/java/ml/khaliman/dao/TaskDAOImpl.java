package ml.khaliman.dao;

import ml.khaliman.model.Task;
import ml.khaliman.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.sql.Date;
import java.util.List;

@Repository
public class TaskDAOImpl implements TaskDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Task task) {
        entityManager.merge(task);
    }

    @Override
    public void delete(long[] ids) {
        Task c;
        for (long id : ids) {
            c = entityManager.getReference(Task.class, id);
            entityManager.remove(c);
        }
    }

   /* @Override
    public List<Task> list(User user, int start, int count) {
        TypedQuery<Task> query;

        if (user != null) {
            query = entityManager.createQuery("SELECT c FROM Task c WHERE c.user = :user ORDER BY c.id DESC", Task.class);
            query.setParameter("user", user);
        } else {
            query = entityManager.createQuery("SELECT c FROM Task c ORDER BY c.id DESC", Task.class);
        }

        if (start >= 0) {
            query.setFirstResult(start);
            query.setMaxResults(count);
        }

        return query.getResultList();
    }

    @Override
    public List<Task> list(Date pattern) {
        TypedQuery<Task> query = entityManager.createQuery("SELECT c FROM Task c WHERE c.date LIKE :pattern", Task.class);
        query.setParameter("pattern", "%" + pattern + "%");
        return query.getResultList();
    }

    @Override
    public long count() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(c) FROM Task c", Long.class);
        return query.getSingleResult();
    }*/
}