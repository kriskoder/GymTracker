package pl.coderslab.app.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.app.history.History;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {


}
