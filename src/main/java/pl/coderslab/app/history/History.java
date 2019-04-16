package pl.coderslab.app.history;

import org.hibernate.validator.constraints.NotBlank;
import pl.coderslab.app.exercise.Exercise;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private int weight;
    @NotNull
    private int reps;
    private LocalDateTime created;
    @OneToOne
    private Exercise exercise;
}
