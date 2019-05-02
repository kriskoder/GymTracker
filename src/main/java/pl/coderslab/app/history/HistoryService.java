package pl.coderslab.app.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.app.exercise.ExerciseRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<History> getExerciseHistory(Long userId, Long exerciseId) {
        return historyRepository.findHistoryByUserIdAndExerciseIdOrderByTrainingDesc(userId, exerciseId);
    }

    public List<History> getUserHistory(Long userId, Long trainingId) {
        return historyRepository.findHistoryByUserIdAndTrainingId(userId, trainingId);
    }

    public History getMaxRestult(Long userId, Long exerciseId) {
        return historyRepository.findTopHistoryByUserIdAndExerciseIdOrderByWeightDesc(userId, exerciseId);
    }

    public History getMinResult(Long userId, Long exerciseId) {
        return historyRepository.findTopHistoryByUserIdAndExerciseIdOrderByWeightAsc(userId, exerciseId);
    }
}

