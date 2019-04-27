package pl.coderslab.app.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findHistoryByUserIdAndAndTrainingId(Long userId, Long trainingId);

    List<History> findHistoryByUserIdAndExerciseIdOrderByTrainingDesc(Long userId, Long exerciseId);


    History findTopHistoryByUserIdAndExerciseIdOrderByWeightDesc(Long userId, Long exerciseId);

    History findTopHistoryByUserIdAndExerciseIdOrderByWeightAsc(Long userId, Long exerciseId);
}
