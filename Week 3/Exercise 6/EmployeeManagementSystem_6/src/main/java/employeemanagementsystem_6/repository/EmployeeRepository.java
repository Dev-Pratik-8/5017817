package librarymanagement.employeemanagementsystem_6.repository;

import librarymanagement.employeemanagementsystem_6.entity.Employee;
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
    List<Employee> findByDepartmentId(@Param("departmentId") Long departmentId);

    // Using the named query to find an employee by email
    @Query(name = "Employee.findByEmailNamedQuery")
    Employee findByEmail(@Param("email") String email);


    // Find all employees with pagination
    Page<Employee> findAll(Pageable pageable);

    // Find employees by name containing a specific substring with pagination and sorting
    Page<Employee> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
