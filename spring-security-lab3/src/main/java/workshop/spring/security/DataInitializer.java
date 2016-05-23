package workshop.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import workshop.spring.security.entity.Category;
import workshop.spring.security.entity.Role;
import workshop.spring.security.entity.Todo;
import workshop.spring.security.entity.User;
import workshop.spring.security.repository.CategoryRepository;
import workshop.spring.security.repository.RoleRepository;
import workshop.spring.security.repository.TodoRepository;
import workshop.spring.security.repository.UserRepository;

import java.util.Collections;
import java.util.Date;
import java.util.stream.Stream;

/**
 * Initializer for test data.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataInitializer.class);

    private RoleRepository roleRepository;

    private UserRepository userRepository;

    private CategoryRepository categoryRepository;

    private TodoRepository todoRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(RoleRepository roleRepository, UserRepository userRepository,
                           CategoryRepository categoryRepository, TodoRepository todoRepository, PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.todoRepository = todoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        LOGGER.info("Creating test data...");

        final Role admin = roleRepository.save ( new Role ( "ADMIN" ) );
        final Role user = roleRepository.save ( new Role ( "USER" ) );

        Stream
            .of(
                new User( "user", passwordEncoder.encode("geheim"), "Hans", "Mustermann", Collections.singleton ( user ), true ),
                new User ( "admin", passwordEncoder.encode("admin"), "Hans", "Administrator", Collections.singleton ( admin ), true )
            )
            .forEach(u -> userRepository.save(u));

        final Category category1 = categoryRepository.save ( new Category ( "Business" ) );
        final Category category2 = categoryRepository.save ( new Category ( "Sports" ) );

        todoRepository.save ( new Todo( "Meeting organisieren", "Zur Vorbereitung des neuen Projektes soll ein Kickoff organisiert werden",
                new Date(), new Date (), category1 ) );
        todoRepository.save ( new Todo ( "Lauftraining", "10 km Lauftraining", new Date (), new Date (), category2 ) );

        LOGGER.info("Created test data...");

    }

}
