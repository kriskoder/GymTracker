package pl.coderslab.app.training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

List<Training> findFirst3ByUserIdOrderByCreatedDesc(Long userId);

List<Training> findAllByUserIdOrderByCreatedDesc(Long userId);
}
