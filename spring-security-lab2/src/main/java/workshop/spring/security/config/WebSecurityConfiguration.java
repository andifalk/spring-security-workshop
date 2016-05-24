package workshop.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Tweak auto configured web security configuration a bit with
 * more users and a login form.
 */
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthentication ()
                .withUser ( "user" ).password ( "secret" ).roles ( "USER" )
                .and ()
                .withUser ( "admin" ).password ( "admin" ).roles ( "ADMIN" );
    }
}
