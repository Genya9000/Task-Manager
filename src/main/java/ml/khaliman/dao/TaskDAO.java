package ml.khaliman.dao;
import ml.khaliman.model.Task;
import ml.khaliman.model.User;
import java.util.List;

public interface TaskDAO {
    void add(Task task);

    void delete(long[] ids);

    List<Task> list(User user);

    void update(long id, String text);
}
