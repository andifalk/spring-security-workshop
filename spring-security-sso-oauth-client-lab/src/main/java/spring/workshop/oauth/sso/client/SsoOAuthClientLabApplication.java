package spring.workshop.oauth.sso.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class SsoOAuthClientLabApplication {

    private OAuth2ProtectedResourceDetails resourceDetails;
    private OAuth2ClientContext clientContext;

    public static void main(String[] args) {
		SpringApplication.run(SsoOAuthClientLabApplication.class, args);
	}

    @RequestMapping(path = "/")
    public String index(Principal principal) {
        User user = (User) ((OAuth2Authentication) principal).getPrincipal();
        return String.format("Successfully authenticated user '%s', first name '%s', last name '%s'",
                user.getName(),
                user.getFirstName(), user.getFirstName());
    }

    @RequestMapping(path = "/protected")
    public String protectedResource() {
        return restTemplate().getForObject("http://localhost:9094/resource/protected", String.class);
    }

    @Bean
    public OAuth2RestTemplate restTemplate() {
        return new OAuth2RestTemplate(resourceDetails, clientContext);
    }

    @Autowired
    public void setResourceDetails(OAuth2ProtectedResourceDetails resourceDetails) {
        this.resourceDetails = resourceDetails;
    }

    @Autowired
    public void setClientContext(OAuth2ClientContext clientContext) {
        this.clientContext = clientContext;
    }

}
