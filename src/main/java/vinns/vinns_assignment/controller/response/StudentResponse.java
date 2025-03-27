package vinns.vinns_assignment.controller.response;

import lombok.Builder;
import lombok.Getter;
import vinns.vinns_assignment.domain.Student;


@Getter
public class StudentResponse {

    private Integer No;
    private String Name;
    private String Gender;
    private int grade;
    private int Track;

    @Builder
    public StudentResponse(Student student) {
        this.No = student.getSeq();
        this.Name = student.getName();
        this.Gender = student.getGender().toString();
        this.grade = student.getLevel();
        this.Track = student.getTrack();
    }
}
