package home.demo.springtestsdemov1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @GetMapping("students/{id}")
    public Student getStudentById(@PathVariable Long id){
        return service.getStudentById(id);
    }
}
