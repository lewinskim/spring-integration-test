package home.demo.springtestsdemov1;

import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void shouldReturnStudentDetails(){
        //given
        Student marek = new Student(null, "Marek");
        Student savedStudent = testEntityManager.persistFlushFind(marek);
        //when
        Student student = repository.getStudentByName("Marek");
        //then
        BDDAssertions.then(savedStudent.getId()).isNotNull();
        BDDAssertions.then(student.getName()).isEqualTo(marek.getName());
    }
}
