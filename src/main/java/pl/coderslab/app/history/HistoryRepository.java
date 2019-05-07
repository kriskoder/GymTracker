package pl.coderslab.app.history;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

    List<History> findHistoryByUserIdAndTrainingId(Long userId, Long trainingId);

    List<History> findHistoryByUserIdAndExerciseIdOrderByTrainingDesc(Long userId, Long exerciseId);

    History findTopHistoryByUserIdAndExerciseIdOrderByWeightDesc(Long userId, Long exerciseId);

    History findTopHistoryByUserIdAndExerciseIdOrderByWeightAsc(Long userId, Long exerciseId);

    void deleteAllHistoryByTrainingId(Long trainingId);
}
