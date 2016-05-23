package workshop.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Starter class for spring boot app.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "workshop.spring.security.repository")
public class SpringSecurityLab3Application {

    public static void main(String[] args) {
        SpringApplication.run( SpringSecurityLab3Application.class, args);
    }

}
