package vinns.vinns_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vinns.vinns_assignment.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
