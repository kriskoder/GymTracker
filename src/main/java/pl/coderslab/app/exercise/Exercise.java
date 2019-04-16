package pl.coderslab.app.exercise;

import org.hibernate.Hibernate;
import pl.coderslab.app.history.History;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "exercise")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2)
    private String name;
    @Size(min = 30)
    private String description;
    @ManyToOne
    private History training;
    @OneToOne(mappedBy = "exercise")
    private History history;
}