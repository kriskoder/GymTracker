package pl.coderslab.app.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExerciseService {
    @Autowired
    ExerciseRepository exerciseRepository;

    public void create(Exercise exercise){
        exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }
}
