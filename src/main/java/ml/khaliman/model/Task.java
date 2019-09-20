package ml.khaliman.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date date;
    private String text;
}
