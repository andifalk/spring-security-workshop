package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.User;
import workshop.spring.security.repository.UserRepository;

import java.util.List;

/**
 * Implementation of {@link UserService}.
 */
@Service("userDetails")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername ( String username ) throws UsernameNotFoundException {
        return userRepository.findOneByUsername ( username );
    }

    @Override
    public User save ( User entity ) {
        return userRepository.save ( entity );
    }

    @Override
    public List<User> findAll () {
        return userRepository.findAll ();
    }
}
