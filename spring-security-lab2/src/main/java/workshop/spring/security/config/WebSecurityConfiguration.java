package workshop.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security configuration.
 */
//@EnableWebSecurity
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
