package librarymanagement.employeemanagementsystem_10.repository.primary;

import librarymanagement.employeemanagementsystem_10.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryEmployeeRepository extends JpaRepository<Employee, Long> {
}
