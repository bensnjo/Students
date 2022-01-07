package ke.go.kra.students.Students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
   /* @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){

        return args -> {
         Student jamal= new Student(
                        "jamal",
                        LocalDate.of(2000,04,22),
                      "ben@ss.com"
                );
            Student benson= new Student(
                    "benson",
                    LocalDate.of(2005,8,02),
                    "jyn@ss.com"
            );
        repository.saveAll(List.of(jamal, benson));
        };
    }*/
}
