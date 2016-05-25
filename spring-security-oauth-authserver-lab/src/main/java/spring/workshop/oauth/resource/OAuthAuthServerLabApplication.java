package spring.workshop.oauth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableAuthorizationServer
@EnableResourceServer
@SpringBootApplication
public class OAuthAuthServerLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthAuthServerLabApplication.class, args);
	}

    @RequestMapping(path = "/user")
    public User user(Principal principal) {
        if (((OAuth2Authentication) principal).getPrincipal() instanceof User) {
            return (User) ((OAuth2Authentication) principal).getPrincipal ();
        } else {
            return new User ( principal.getName (), "", "Hans", "Mustermann", ((OAuth2Authentication) principal).getAuthorities () );
        }
    }

}
