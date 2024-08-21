package librarymanagement.employeemanagementsystem_10.service;

import jakarta.transaction.Transactional;
import librarymanagement.employeemanagementsystem_10.entity.Employee;
import librarymanagement.employeemanagementsystem_10.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Page<Employee> getAllEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> searchEmployeesByName(String name, Pageable pageable) {
        return employeeRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    @Transactional
    public void saveAllEmployees(List<Employee> employees) {
        int batchSize = 50; // This should match hibernate.jdbc.batch_size
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i % batchSize == 0) { // Flush and clear the persistence context every batch
                employeeRepository.flush();
                employeeRepository.clear();
            }
        }
    }
}
