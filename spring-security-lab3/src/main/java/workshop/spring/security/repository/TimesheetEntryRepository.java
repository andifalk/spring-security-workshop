package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.TimesheetEntry;

/**
 * JPA repository for {@link TimesheetEntry timesheet entries}.
 */
public interface TimesheetEntryRepository extends JpaRepository<TimesheetEntry, Long> {
}
