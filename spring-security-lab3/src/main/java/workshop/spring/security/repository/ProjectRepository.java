package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.Project;

/**
 * JPA repository for {@link Project projects}.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
