package home.demo.springtestsdemov1;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private StudentService studentService;

    @Test
    void shouldGetStudentByIdForSavedStudent() {
        //given
        Student student = new Student(null, "Student1");
        Student savedStudent = repository.save(student);

        //when
        Student fetchedStudent = studentService.getStudentById(savedStudent.getId());

        //then
        BDDAssertions.then(fetchedStudent.getName()).isEqualTo("Student1");
        BDDAssertions.then(fetchedStudent.getId()).isNotNull();
    }

    @Test
    void shouldThrowUserNotFoundException() {
        //given
        Long id = 666L;

        //when
        Throwable throwable = Assertions.catchThrowable(() -> studentService.getStudentById(id));

        //then
        BDDAssertions.then(throwable).isInstanceOf(StudentNotFoundException.class);
    }
}
