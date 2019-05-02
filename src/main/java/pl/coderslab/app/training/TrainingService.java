package pl.coderslab.app.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.app.user.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    public Training create(User user, String name){
        Training training = new Training();
        training.setUser(user);
        training.setName(name);
        trainingRepository.save(training);
        return training;
    }

    public String getTrainingName(Long id){
        return trainingRepository.findById(id).orElse(null).getName();
    }

    public List<Training> getLast3TrainingsByUserId(Long id){
        return trainingRepository.findFirst3ByUserIdOrderByCreatedDesc(id);
    }

    public List<Training> getAllUserTrainings(Long id){
        return trainingRepository.findAllByUserIdOrderByCreatedDesc(id);
    }
}
