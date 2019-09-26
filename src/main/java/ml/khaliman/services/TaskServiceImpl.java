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
    @Transactional
    public boolean ifExist(String login) {
       if(userDAO.findOne(login).equals(null))
           return false;
       else return true;

    }

/*
    @Transactional(readOnly=true)
    public List<User> listUsers() {
        return userDAO.list();
    }

    @Transactional(readOnly=true)
    public List<Task> listTasks(User user, int start, int count) {
        return taskDAO.list(user, start, count);
    }



    @Transactional(readOnly=true)
    public List<Task> listTasks(User user) {
        return taskDAO.list(user, 0, 0);
    }

    @Transactional(readOnly = true)
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
