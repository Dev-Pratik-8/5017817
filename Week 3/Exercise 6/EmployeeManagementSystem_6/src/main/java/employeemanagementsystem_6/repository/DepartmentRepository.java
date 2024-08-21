package librarymanagement.employeemanagementsystem_6.repository;

import librarymanagement.employeemanagementsystem_6.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
