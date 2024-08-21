package librarymanagement.employeemanagementsystem_9.repository;

import librarymanagement.employeemanagementsystem_9.dto.EmployeeNameAndEmailDto;
import librarymanagement.employeemanagementsystem_9.entity.Employee;
import librarymanagement.employeemanagementsystem_9.projection.EmployeeNameAndEmailProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentName(String departmentName);

    // Custom JPQL query to find employees by name, ignoring case
    @Query("SELECT e FROM Employee e WHERE LOWER(e.name) = LOWER(:name)")
    List<Employee> findByNameIgnoreCase(@Param("name") String name);

    // Custom native SQL query to find employees by department ID
    @Query(value = "SELECT * FROM employees e WHERE e.department_id = :departmentId", nativeQuery = true)
    List<Employee> findEmployeesByDepartmentId(@Param("departmentId") Long departmentId);

    // Using the named query to find an employee by email
    @Query(name = "Employee.findByEmailNamedQuery")
    Employee findByEmail(@Param("email") String email);

    // Find all employees with pagination
    Page<Employee> findAll(Pageable pageable);

    // Find employees by name containing a specific substring with pagination and sorting
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Projection for finding employees by department ID
    List<EmployeeNameAndEmailProjection> findProjectedByDepartmentId(Long departmentId);

    @Query("SELECT new librarymanagement.employeemanagementsystem_9.dto.EmployeeNameAndEmailDto(e.name, e.email) " +
            "FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeNameAndEmailDto> findEmployeeNameAndEmailByDepartmentId(@Param("departmentId") Long departmentId);

    List<EmployeeNameAndEmailProjection> findCustomProjectionByDepartmentId(Long departmentId);
}
