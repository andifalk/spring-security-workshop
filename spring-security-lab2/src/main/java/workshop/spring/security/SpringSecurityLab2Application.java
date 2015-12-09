package workshop.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Starter class for spring boot app.
 */
@SpringBootApplication
@RestController
public class SpringSecurityLab2Application {

    public static void main(String[] args) {
        SpringApplication.run( SpringSecurityLab2Application.class, args);
    }


}
