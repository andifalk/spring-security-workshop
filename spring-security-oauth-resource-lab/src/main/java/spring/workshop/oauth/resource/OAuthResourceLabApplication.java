package spring.workshop.oauth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableResourceServer
@SpringBootApplication
public class OAuthResourceLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuthResourceLabApplication.class, args);
	}

	@RequestMapping(path = "/protected")
	public String protectedResource(Principal principal) {
		return String.format("Accessed protected resource using user '%s'", principal.getName());
	}

}
