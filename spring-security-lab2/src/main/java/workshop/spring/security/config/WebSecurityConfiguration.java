package workshop.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security configuration.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthentication ()
                .withUser ( "user" ).password ( "secure" ).roles ( "USER" )
                .and ()
                .withUser ( "admin" ).password ( "admin" ).roles ( "ADMIN" );
    }

    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http.csrf ().disable ().formLogin ().permitAll ()
                .loginPage ( "/login" ).loginProcessingUrl ( "/j_spring_security_check" ).usernameParameter ( "username" ).passwordParameter ( "password" )
                .defaultSuccessUrl ( "/" )
                .failureUrl ( "/login?error=true" )
                .and ().logout ().permitAll ().logoutSuccessUrl ( "/login" )
            .and ()
            .authorizeRequests ()
                .anyRequest ().fullyAuthenticated ();
    }

}
