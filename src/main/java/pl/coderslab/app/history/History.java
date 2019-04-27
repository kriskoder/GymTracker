package pl.coderslab.app.history;

import lombok.*;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.exercise.Exercise;
import pl.coderslab.app.user.User;
import javax.persistence.*;



@Entity
@Table(name = "history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    private int weight;
    private int reps;
    @ManyToOne
    private Exercise exercise;

    @ManyToOne
    private Training training;

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", user=" + user +
                ", weight=" + weight +
                ", reps=" + reps +
                ", exercise=" + exercise +
                ", training=" + training +
                '}';
    }
}
