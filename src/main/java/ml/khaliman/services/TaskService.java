package ml.khaliman.services;

import ml.khaliman.model.Task;
import ml.khaliman.model.User;

import java.sql.Date;
import java.util.List;

public interface TaskService {
    void addTask(Task task);
    void addUser(User user);
    void deleteTask(long[] ids);

}
