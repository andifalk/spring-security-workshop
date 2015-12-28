package workshop.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import workshop.spring.security.entity.Project;
import workshop.spring.security.entity.Role;
import workshop.spring.security.entity.User;
import workshop.spring.security.repository.RoleRepository;
import workshop.spring.security.service.ProjectService;
import workshop.spring.security.service.RoleService;
import workshop.spring.security.service.UserService;

import java.util.Collections;

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
    private ProjectService projectService;


    public static void main(String[] args) {
        SpringApplication.run( SpringSecurityLab3Application.class, args);
    }


    @Override
    public void run ( String... strings ) throws Exception {
        final Role superadmin = roleService.save ( new Role ( "SUPERADMIN" ) );
        final Role admin = roleService.save ( new Role ( "ADMIN" ) );
        roleService.save ( new Role ( "USER" ) );

        userService.save ( new User ( "superadmin", "geheim", "Hans", "SuperAdministrator", Collections.singleton ( superadmin ), true ) );
        userService.save ( new User ( "admin", "admin", "Hans", "Administrator", Collections.singleton ( admin ), true ) );

        projectService.save ( new Project ( "DevProject1", true ) );
        projectService.save ( new Project ( "DevProject2", false ) );

    }
}
