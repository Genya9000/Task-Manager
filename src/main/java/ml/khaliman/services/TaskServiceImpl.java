package ml.khaliman.services;

import ml.khaliman.dao.TaskDAO;
import ml.khaliman.model.Task;
import ml.khaliman.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ml.khaliman.dao.UserDAO;

import java.sql.Date;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDAO;
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void addTask(Task task) {
        taskDAO.add(task);
    }

    @Transactional
    public void addUser(User user) {
        userDAO.add(user);
    }

    @Transactional
    public void deleteTask(long[] ids) {
        taskDAO.delete(ids);
    }

    @Transactional(readOnly=true)
    public boolean ifExist(String login) {
        return userDAO.findOne(login) != null;

    }


    @Transactional(readOnly=true)
    public User findUser(String login) {
        return  (User) userDAO.findOne(login);
    }


    @Transactional(readOnly=true)
    public List<User> listUsers() {
        return userDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Task> listTasks(User user) {
        return taskDAO.list(user);
    }





   /* @Transactional(readOnly = true)
    public long count() {
        return taskDAO.count();
    }

    @Transactional(readOnly=true)
    public User findUser(long id) {
        return userDAO.findOne(id);
    }

    @Transactional(readOnly=true)
    public List<Task> searchTasks(Date pattern) {
        return taskDAO.list(pattern);
    }*/
}
