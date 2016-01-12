package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.Todo;

/**
 * JPA repository for {@link Todo to do entries}.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
