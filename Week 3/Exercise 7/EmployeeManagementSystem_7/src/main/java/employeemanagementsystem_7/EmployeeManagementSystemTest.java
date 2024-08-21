package librarymanagement.employeemanagementsystem_7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeManagementSystemTest {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementSystemTest.class, args);
    }
}
