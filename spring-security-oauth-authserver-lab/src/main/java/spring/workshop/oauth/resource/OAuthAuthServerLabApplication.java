package spring.workshop.oauth.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
            return new User ( principal.getName (), "N/A", "Hans", "Mustermann", ((OAuth2Authentication) principal).getAuthorities () );
        }
    }

    /**
     * Defines custom user details service with password encryption.
     */
    @Order( SecurityProperties.ACCESS_OVERRIDE_ORDER)
    @Configuration
    public static class AuthenticationManagerConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
            authenticationManagerBuilder.userDetailsService(myUserDetailsService()).passwordEncoder ( passwordEncoder () );
        }

        @Bean
        public AuthenticationManagerConfig.MyUserDetailsService myUserDetailsService() {
            return new MyUserDetailsService(passwordEncoder ());
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new Pbkdf2PasswordEncoder();
        }

        public static class MyUserDetailsService implements UserDetailsService {

            private Map<String,User> users = new HashMap<>();

            private PasswordEncoder passwordEncoder;

            public MyUserDetailsService ( PasswordEncoder passwordEncoder ) {
                this.passwordEncoder = passwordEncoder;
            }

            @PostConstruct
            public void initUsers() {
                users.put("user", new User("user",passwordEncoder.encode ( "secret" ),"Mister","User",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
                users.put("admin", new User("admin",passwordEncoder.encode ( "admin" ),"Super","Admin",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
            }

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserDetails userDetails = users.get(username);
                if (userDetails == null) {
                    throw new UsernameNotFoundException(username);
                } else {
                    return userDetails;
                }
            }
        }

    }

}
