package librarymanagement.employeemanagementsystem_10.repository.secondary;

import librarymanagement.employeemanagementsystem_10.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryEmployeeRepository extends JpaRepository<Employee, Long> {
}
