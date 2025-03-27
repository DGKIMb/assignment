package vinns.vinns_assignment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "Score")
@Entity
public class Score {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    private byte value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture")
    private Lecture lecture;

}
