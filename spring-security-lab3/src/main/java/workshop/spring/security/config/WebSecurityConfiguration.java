package workshop.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfTokenRepository;

/**
 * Security configuration.
 */
@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService ( userDetailsService  );
    }

    @Override
    protected void configure ( HttpSecurity http ) throws Exception {
        http.formLogin ().permitAll ()
                .loginPage ( "/login" ).loginProcessingUrl ( "/j_spring_security_check" ).usernameParameter ( "username" ).passwordParameter ( "password" )
                .defaultSuccessUrl ( "/" )
                .failureUrl ( "/login-error" )
                .and ().logout ().logoutUrl ( "/logout" ).permitAll ().logoutSuccessUrl ( "/login" )
            .and ()
                .antMatcher ( "/h2-console/**" )
                .csrf ().disable ().headers ().frameOptions ().disable ()
                .and ()
                .antMatcher ( "/**" )
                .authorizeRequests ()
                .antMatchers ( "/resources/**" ).permitAll ()
                .antMatchers ( "/webjars/**" ).permitAll ()
                .antMatchers ( "/users" ).hasRole ( "SUPERADMIN" )
                .antMatchers ( "/projects" ).hasAnyRole ( "SUPERADMIN", "ADMIN" )
                .antMatchers ( "/timesheet" ).hasAnyRole ( "ADMIN", "USER" )
                .anyRequest ().fullyAuthenticated ();
    }
}
