package home.demo.springtestsdemov1;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StudentCacheTest {

    @Autowired
    private StudentService service;

    @MockBean
    private StudentRepository repository;

    //TODO fix regression

/*    @Test
    void shouldReturnStudentFromCacheForMultipleRequests() {
        //given
        Long id = 12L;
        BDDMockito.given(repository.findById(id)).willReturn(Optional.of(new Student(id, "NotImportantName")));
        //when
        repository.findById(id);
        repository.findById(id);
        repository.findById(id);

        //then
        BDDMockito.then(repository).should(Mockito.times(1)).findById(id);
    }*/
}
