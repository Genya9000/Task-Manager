package ml.khaliman.services;
import ml.khaliman.model.Task;
import ml.khaliman.model.User;

import java.util.List;

public interface TaskService {
    void addTask(Task task);

    void addUser(User user);

    void deleteTask(long[] ids);

    boolean ifExist(String login);

    Object findUser(String login);

    List<Task> listTasks(User user);

    void updateTask(long id, String text);
}
