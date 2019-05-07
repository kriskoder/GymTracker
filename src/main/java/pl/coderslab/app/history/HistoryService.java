package pl.coderslab.app.history;

import org.springframework.stereotype.Service;
import pl.coderslab.app.training.Training;
import pl.coderslab.app.user.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoryService {

    private HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public void create(History history, Training training, User user) {
        history.setTraining(training);
        history.setUser(user);
        historyRepository.save(history);
    }

    public void deleteHistoryByTraining(Long trainingId) {
        historyRepository.deleteAllHistoryByTrainingId(trainingId);
    }

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

