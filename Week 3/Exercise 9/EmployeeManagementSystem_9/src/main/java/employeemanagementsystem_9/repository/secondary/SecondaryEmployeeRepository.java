package librarymanagement.employeemanagementsystem_9.repository.secondary;

import librarymanagement.employeemanagementsystem_9.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryEmployeeRepository extends JpaRepository<Employee, Long> {
}
