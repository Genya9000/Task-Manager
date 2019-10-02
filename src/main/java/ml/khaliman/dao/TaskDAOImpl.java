package ml.khaliman.dao;

import ml.khaliman.model.Task;
import ml.khaliman.model.User;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override

    public List<Task> list(User user) {
        Query query = entityManager.createQuery("SELECT task FROM  Task task WHERE task.user = ?1  ORDER BY task.date DESC ")
                .setParameter(1, user);

        int pageNumber = 1;
        int pageSize = 5;
        query.setFirstResult((pageNumber-1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();

    }
/*
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