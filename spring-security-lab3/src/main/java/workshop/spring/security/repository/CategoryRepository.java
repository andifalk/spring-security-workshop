package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.Category;

/**
 * JPA repository for {@link Category categories}.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
