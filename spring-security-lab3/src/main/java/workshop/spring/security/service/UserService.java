package workshop.spring.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.User;

import java.util.List;

/**
 * Transactional {@link UserService}.
 */
public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {

    @Transactional(readOnly = true)
    @Override
    UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException;

    @Transactional
    User save ( User entity );

    @Transactional(readOnly = true)
    List<User> findAll ();
}
