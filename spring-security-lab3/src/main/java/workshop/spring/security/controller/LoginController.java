package workshop.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Controller for login web page.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login () {
        return "login";
    }

    @RequestMapping(path = "/login-error")
    public String loginError ( Model model ) {
        model.addAttribute ( "error", true );
        return "login";
    }
}
