package vinns.vinns_assignment.controller.response;

import lombok.Builder;
import lombok.Getter;
import vinns.vinns_assignment.service.ParkerAndAliceDto;

@Getter
public class ParkerAndAliceResponse {

    private String name;
    private String grade;
    private int score;
    private int track;

    @Builder
    public ParkerAndAliceResponse(ParkerAndAliceDto dto) {
        this.name = dto.getName();
        this.grade = dto.getLecture().toString().equals("3") ? "10" :
                dto.getLecture().toString().equals("2") ? "11" : "12";
        this.score = dto.getValue().intValue();
        this.track = dto.getTrack().intValue();
    }
}
