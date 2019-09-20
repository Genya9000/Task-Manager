package ml.khaliman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String login;
    private String password;
    @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

}