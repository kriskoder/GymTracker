package pl.coderslab.app.training;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import pl.coderslab.app.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static pl.coderslab.app.dateFormatter.DateFormatter.formatDate;

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
    private LocalDateTime created;
    @ManyToOne
    private User user;
    @Transient
    private String strCreated;

    public String getStrCreated() {
        return formatDate(this.getCreated());
    }
}
