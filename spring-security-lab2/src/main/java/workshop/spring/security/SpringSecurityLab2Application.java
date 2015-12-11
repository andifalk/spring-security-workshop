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
    private static final Logger LOGGER = LoggerFactory.getLogger ( SpringSecurityLab2Application.class );

    public static void main(String[] args) {
        SpringApplication.run( SpringSecurityLab2Application.class, args);
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/")
    public String hello() {
        final Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        LOGGER.info ( "Granted roles are: {}", authentication.getAuthorities () );
        return String.format ( "hello %s, having roles %s",
                ( (UserDetails) authentication.getPrincipal () ).getUsername (), authentication.getAuthorities () );
    }
}
