package librarymanagement.employeemanagementsystem_10.service;

import librarymanagement.employeemanagementsystem_10.entity.Department;
import librarymanagement.employeemanagementsystem_10.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create or Update a Department
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Get all Departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get a Department by ID
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // Delete a Department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
