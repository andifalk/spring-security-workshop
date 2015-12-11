package workshop.spring.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by AFA on 09.12.2015.
 */
@Controller
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger ( AppController.class );


    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/")
    public String index( Model model ) {
        final Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        LOGGER.info ( "Granted roles are: {}", authentication.getAuthorities () );
        model.addAttribute ( "username", "Hello " + ( (UserDetails) authentication.getPrincipal () ).getUsername () );
        return "index";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/admin")
    public String admin() {
        return "admin";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/audit")
    public String audit() {
        return "audit";
    }

}
