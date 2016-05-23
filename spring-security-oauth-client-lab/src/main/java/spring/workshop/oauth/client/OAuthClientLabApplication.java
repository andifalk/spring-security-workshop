package spring.workshop.oauth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Client
@SpringBootApplication
public class OAuthClientLabApplication {

    private OAuth2ProtectedResourceDetails resourceDetails;

    private OAuth2ClientContext clientContext;

	public static void main(String[] args) {
		SpringApplication.run(OAuthClientLabApplication.class, args);
	}

    @RequestMapping(path = "/")
    public String index() {
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
