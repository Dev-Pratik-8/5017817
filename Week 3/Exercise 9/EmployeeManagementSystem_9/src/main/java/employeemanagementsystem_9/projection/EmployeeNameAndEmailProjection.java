package librarymanagement.employeemanagementsystem_9.projection;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeNameAndEmailProjection {
    String getName();
    String getEmail();
    @Value("#{target.name + ' (' + target.email + ')'}")
    String getDisplayName();
}
