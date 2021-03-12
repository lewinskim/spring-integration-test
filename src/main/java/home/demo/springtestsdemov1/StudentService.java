package home.demo.springtestsdemov1;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StudentService {

    private final StudentRepository repository;

    @Cacheable("students")
    public Student getStudentById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new StudentNotFoundException(String.format("Student with id %d not found", id)));
    }
}
