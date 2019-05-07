package pl.coderslab.app.exercise;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExerciseService {

    private ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public void create(Exercise exercise){
        exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }

    public String getExerciseNameById(Long id){
       return exerciseRepository.findById(id).orElse(null).getName();
    }
}
