package librarymanagement.employeemanagementsystem_8.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameAndEmailProjection {
    String getName();
    String getEmail();
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getDisplayName();
}
