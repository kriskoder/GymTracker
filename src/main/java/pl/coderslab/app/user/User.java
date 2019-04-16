package pl.coderslab.app.user;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.history.History;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2)
    private String name;
    @Email
    private String email;
    @NotBlank
    private String password;
    @OneToOne
    private User user;
    @OneToMany
    private List<History> historyList;

}
