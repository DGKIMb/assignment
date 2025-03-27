package vinns.vinns_assignment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Table(name = "Student")
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Column(length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private byte level;

    private byte track;
}
