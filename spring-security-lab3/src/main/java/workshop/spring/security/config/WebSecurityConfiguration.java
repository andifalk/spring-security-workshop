package workshop.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

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
        http.formLogin ().permitAll ()
                .loginPage ( "/login" ).loginProcessingUrl ( "/j_spring_security_check" ).usernameParameter ( "username" ).passwordParameter ( "password" )
                .defaultSuccessUrl ( "/" )
                .failureUrl ( "/login-error" )
                .and ().logout ().logoutUrl ( "/logout" ).permitAll ().logoutSuccessUrl ( "/login" )
            .and ()
            .authorizeRequests ()
                .antMatchers ( "/resources/**" ).permitAll ()
                .antMatchers ( "/webjars/**" ).permitAll ()
                .antMatchers ( "/users" ).hasAnyRole ( "ADMIN", "USER" )
                .antMatchers ( "/admin" ).hasRole ( "ADMIN" )
                .antMatchers ( "/audit" ).hasAnyRole ( "ADMIN", "AUDITOR" )
                .anyRequest ().fullyAuthenticated ();
    }
}
