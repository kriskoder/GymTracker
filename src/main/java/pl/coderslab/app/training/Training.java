package pl.coderslab.app.training;

import lombok.*;
import pl.coderslab.app.user.User;

import javax.persistence.*;

@Entity
@Table(name = "training")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String created;
    @ManyToOne
    private User user;
}
