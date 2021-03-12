package home.demo.springtestsdemov1;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void shouldReturnStudentDetails() {
        //given
        Student marek = new Student(null, "Marek");
        Student savedStudent = testEntityManager.persistFlushFind(marek);
        //when
        Student student = repository.getStudentByName("Marek");

        //then
        BDDAssertions.then(savedStudent.getId()).isNotNull();
        BDDAssertions.then(student.getName()).isEqualTo(marek.getName());
    }

    @Test
    void shouldReturnAvgGradeForActiveStudents() {
        //given
        Student student1 = Student.builder().name("Student1").active(true).grade(100).build();
        Student student2 = Student.builder().name("Student2").active(true).grade(50).build();
        Student student3 = Student.builder().name("Student3").active(false).grade(100).build();
        List.of(student1, student2, student3).forEach(testEntityManager::persistFlushFind);

        //when
        Double avgGrade = repository.getActiveStudentAvgGrade();

        //then
        BDDAssertions.then(avgGrade).isEqualTo(75);
    }
}
