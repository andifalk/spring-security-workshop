package workshop.spring.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AFA on 09.12.2015.
 */
@RestController
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger ( AppController.class );


    /**
     * Restful service.
     * @return message
     */
    @Secured ( "ROLE_USER" )
    @RequestMapping(path = "/")
    public String hello() {
        final Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        LOGGER.info ( "Granted roles are: {}", authentication.getAuthorities () );
        return String.format ( "hello %s, having roles %s",
                ( (UserDetails) authentication.getPrincipal () ).getUsername (), authentication.getAuthorities () );
    }

    /**
     * Restful service.
     * @return message
     */
    @Secured ( "ROLE_ADMIN" )
    @RequestMapping(path = "/admin")
    public String admin() {
        return "Administration page";
    }

    /**
     * Restful service.
     * @return message
     */
    @Secured ( "ROLE_AUDITOR" )
    @RequestMapping(path = "/audit")
    public String audit() {
        return "Audit page";
    }

}
