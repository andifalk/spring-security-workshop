package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.Role;

/**
 * JPA repository for {@link workshop.spring.security.entity.Role roles}.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findOneByName ( String name );
}
