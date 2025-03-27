package vinns.vinns_assignment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Table(name = "Lecture")
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(length = 50)
    private String title;

    @Column(length = 30)
    private String subject;

}
