package home.demo.springtestsdemov1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringTestsDemoV1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringTestsDemoV1Application.class, args);
    }

}
