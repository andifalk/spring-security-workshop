package workshop.spring.security.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by AFA on 10.12.2015.
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
