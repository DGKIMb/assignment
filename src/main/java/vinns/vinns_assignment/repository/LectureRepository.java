package vinns.vinns_assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vinns.vinns_assignment.domain.Lecture;

public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
