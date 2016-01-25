package workshop.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Security configuration.
 */
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal ( AuthenticationManagerBuilder auth ) throws Exception {
        auth.userDetailsService ( userDetailsService  );
    }

    @Configuration
    @Order(1)
    public static class H2ConsoleWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/h2-console/**")
                    .csrf ().disable ()
                    .headers ().frameOptions ().disable ()
                    .and ()
                    .formLogin ().permitAll ()
                    .loginPage ( "/login" ).loginProcessingUrl ( "/j_spring_security_check" ).usernameParameter ( "username" ).passwordParameter ( "password" )
                    .defaultSuccessUrl ( "/h2-console" )
                    .failureUrl ( "/login-error" )
                    .and ()
                    .authorizeRequests ()
                    .anyRequest ().fullyAuthenticated ();
        }
    }

    @Configuration
    public static class ApplicationWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .formLogin ().permitAll ()
                    .loginPage ( "/login" ).loginProcessingUrl ( "/j_spring_security_check" ).usernameParameter ( "username" ).passwordParameter ( "password" )
                    .defaultSuccessUrl ( "/" )
                    .failureUrl ( "/login-error" )
                    .and ()
                    .logout ().logoutUrl ( "/logout" ).permitAll ().logoutSuccessUrl ( "/login" )
                    .and ()
                    .authorizeRequests ()
                    .antMatchers ( "/resources/**" ).permitAll ()
                    .antMatchers ( "/webjars/**" ).permitAll ()
                    .antMatchers ( "/users" ).hasRole ( "ADMIN" )
                    .antMatchers ( "/categories" ).hasRole ( "ADMIN" )
                    .antMatchers ( "/todo" ).hasAnyRole ( "ADMIN", "USER" )
                    .anyRequest ().fullyAuthenticated ();
        }

    }

}
