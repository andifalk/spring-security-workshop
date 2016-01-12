package workshop.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import workshop.spring.security.entity.Category;
import workshop.spring.security.entity.Role;
import workshop.spring.security.entity.Todo;
import workshop.spring.security.entity.User;
import workshop.spring.security.service.CategoryService;
import workshop.spring.security.service.RoleService;
import workshop.spring.security.service.ToDoService;
import workshop.spring.security.service.UserService;

import java.util.Collections;
import java.util.Date;

/**
 * Starter class for spring boot app.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "workshop.spring.security.repository")
public class SpringSecurityLab3Application implements CommandLineRunner {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ToDoService toDoService;


    public static void main(String[] args) {
        SpringApplication.run( SpringSecurityLab3Application.class, args);
    }


    @Override
    public void run ( String... strings ) throws Exception {
        final Role admin = roleService.save ( new Role ( "ADMIN" ) );
        final Role user = roleService.save ( new Role ( "USER" ) );

        userService.save ( new User ( "user", "geheim", "Hans", "Mustermann", Collections.singleton ( user ), true ) );
        userService.save ( new User ( "admin", "admin", "Hans", "Administrator", Collections.singleton ( admin ), true ) );

        final Category category1 = categoryService.save ( new Category ( "Business" ) );
        final Category category2 = categoryService.save ( new Category ( "Sports" ) );

        toDoService.save ( new Todo ( "Meeting organisieren", "Zur Vorbereitung des neuen Projektes soll ein Kickoff organisiert werden",
                new Date (), new Date (), category1 ) );
        toDoService.save ( new Todo ( "Lauftraining", "10 km Lauftraining", new Date (), new Date (), category2 ) );

    }
}
