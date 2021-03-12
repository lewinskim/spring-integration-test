package home.demo.springtestsdemov1;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService service;

    @Test
    void shouldReturnSavedStudent() throws Exception {
        //given
        BDDMockito.given(service.getStudentById(ArgumentMatchers.anyLong())).willReturn(
                Student.builder()
                        .id(1L)
                        .name("Student1")
                        .grade(100)
                        .build()
        );
        //when

        //then
        mockMvc.perform(MockMvcRequestBuilders.get("/students/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Student1"))
                .andExpect(MockMvcResultMatchers.jsonPath("grade").value(100));
    }

}
