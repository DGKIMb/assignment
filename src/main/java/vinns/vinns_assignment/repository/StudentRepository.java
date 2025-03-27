package vinns.vinns_assignment.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vinns.vinns_assignment.domain.Student;
import vinns.vinns_assignment.service.AverageDto;
import vinns.vinns_assignment.service.ParkerAndAliceDto;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = """
        SELECT 
            st.track AS track,
            st.level AS level,
            AVG(sc.value) AS avg
        FROM Student st
        JOIN Score sc ON st.seq = sc.student
        WHERE st.level IN (10,11,12)
        GROUP BY st.track, st.level
        ORDER BY st.level
        """, nativeQuery = true)
    List<AverageDto> getAverages();

    @Query(value = """
        SELECT st.name AS name,
               sc.lecture AS lecture,
               sc.value AS value
        FROM Student st
        JOIN Score sc ON st.seq = sc.student
        WHERE st.seq = :seq1 OR st.seq = :seq2
        ORDER BY st.seq, sc.lecture
        """, nativeQuery = true)
    List<ParkerAndAliceDto> getParkerAndAlice(@Param("seq1") Integer seq1, @Param("seq2") Integer seq2);

    Student findByName(String name);

    Page<Student> findByLevel(int level, Pageable pageable);


}
