package librarymanagement.employeemanagementsystem_8;

import librarymanagement.employeemanagementsystem_8.entity.Employee;
import librarymanagement.employeemanagementsystem_8.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee();
        employee.setName("John Doe");
        employee.setEmail("john.doe@example.com");
        employeeRepository.save(employee);
    }

    @Test
    public void testFindByEmail() {
        Employee foundEmployee = employeeRepository.findByEmail("john.doe@example.com");
        assertNotNull(foundEmployee);
        assertEquals(employee.getName(), foundEmployee.getName());
    }

    @Test
    public void testFindByNameContainingIgnoreCase() {
        List<Employee> employees = employeeRepository.findByNameContainingIgnoreCase("john");
        assertThat(employees).isNotEmpty();
        assertEquals(1, employees.size());
    }

    @Test
    public void testFindByDepartmentName() {
        List<Employee> employees = employeeRepository.findByDepartmentName("IT");
        assertThat(employees).isEmpty();
    }
}
