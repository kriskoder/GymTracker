package pl.coderslab.app.training;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.app.user.User;

import javax.persistence.*;
import java.util.Date;

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
    @CreationTimestamp
    private Date created;
    @ManyToOne
    private User user;
}
