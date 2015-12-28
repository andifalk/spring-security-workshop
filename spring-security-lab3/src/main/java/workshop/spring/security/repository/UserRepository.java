package workshop.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workshop.spring.security.entity.User;

/**
 * JPA repository for {@link User users}.
 */
public interface UserRepository extends JpaRepository<User,Long> {

    User findOneByUsername(String username);
}
