package vinns.vinns_assignment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vinns.vinns_assignment.controller.response.ParkerAndAliceResponse;
import vinns.vinns_assignment.controller.response.StudentResponse;
import vinns.vinns_assignment.domain.Student;
import vinns.vinns_assignment.repository.StudentRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Page<StudentResponse> getStudents(int grade, Pageable pageable) {
        return studentRepository.findByLevel(grade, pageable)
                .map(student -> StudentResponse.builder()
                        .student(student)
                        .build());
    }

    public Map<String, Map<String, Double>> getAverageScores() {
        List<AverageDto> averages = studentRepository.getAverages();

        Map<String, Map<String, Double>> resultMap = new HashMap<>();

        for (AverageDto dto : averages) {
            String track = dto.getTrack().toString();
            String level = dto.getLevel().toString();
            Double avg = dto.getAvg();

            resultMap
                    .computeIfAbsent(track, k -> new HashMap<>())
                    .put(level, avg);
        }

        return resultMap;
    }

    public List<ParkerAndAliceResponse> getParkerAndAlices() {
        Student parker = studentRepository.findByName("Parker");
        Student alice = studentRepository.findByName("Alice");

        List<ParkerAndAliceDto> dtos = studentRepository.getParkerAndAlice(parker.getSeq(), alice.getSeq());

        for (ParkerAndAliceDto temp : dtos) {
            log.info("#################" + temp.getLecture().toString());
        }

        List<ParkerAndAliceResponse> responses = dtos.stream()
                .map(dto -> ParkerAndAliceResponse.builder().dto(dto).build())
                .toList();

        return responses;
    }


}
