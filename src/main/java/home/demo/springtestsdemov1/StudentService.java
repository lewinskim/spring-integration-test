package home.demo.springtestsdemov1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
