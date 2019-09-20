package ml.khaliman.dao;

import ml.khaliman.model.Task;
import ml.khaliman.model.User;

import java.sql.Date;
import java.util.List;

public interface TaskDAO {
    void add(Task task);
    void delete(long[] ids);
    /*List<Task> list(User user, int start, int count);
    List<Task> list(Date pattern);
    long count();*/
}
