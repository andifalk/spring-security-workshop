package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.User;
import workshop.spring.security.repository.UserRepository;

import java.util.List;

/**
 * Implementation of {@link UserService}.
 */
@Service("userDetails")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Secured( "IS_AUTHENTICATED_ANONYMOUSLY" )
    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        final User user = userRepository.findOneByUsername ( username );
        if ( user == null ) {
            throw new UsernameNotFoundException ( String.format ( "No user found for username %s", username ) );
        }
        return user;
    }

    @Transactional
    @Override
    public User save ( User entity ) {
        return userRepository.save ( entity );
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll () {
        return userRepository.findAll ();
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
