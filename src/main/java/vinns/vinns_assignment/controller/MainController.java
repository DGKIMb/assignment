package vinns.vinns_assignment.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vinns.vinns_assignment.controller.response.ParkerAndAliceResponse;
import vinns.vinns_assignment.controller.response.StudentResponse;
import vinns.vinns_assignment.service.StudentService;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final StudentService studentService;

    @GetMapping("/main")
    public String mainPage(
//            @RequestParam(defaultValue = "10") int grade,
//            @PageableDefault(size = 3) Pageable pageable,
            Model model
    ) {

        Map<String, Map<String, Double>> averageScores = studentService.getAverageScores();
        List<ParkerAndAliceResponse> scores = studentService.getParkerAndAlices();
//        Page<StudentResponse> studentPage = studentService.getStudents(grade, pageable);

        model.addAttribute("scores", scores);
//        model.addAttribute("studentPage", studentPage);
        model.addAttribute("averageScores", averageScores);


//        model.addAttribute("grade", grade);

        return "main";
    }

    @GetMapping("/students")
    @ResponseBody
    public Page<StudentResponse> getStudents(
            @RequestParam(defaultValue ="10") int grade,
            @PageableDefault(size = 3) Pageable pageable
    ) {

        return studentService.getStudents(grade, pageable);
    }

}
