package pl.coderslab.app.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Long> {

List<History> findAllByUserId(Long userId);
List<History> findAllByTrainingId(Long Id);

    @Query("select h from History h join h.training where h.user.id = ?1 and h.exercise.id = ?2")
    List<History> findProgress(Long userId, Long exerciseId);
}
