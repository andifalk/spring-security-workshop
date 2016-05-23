package workshop.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security configuration.
 */
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Autowired
    public void configureGlobal ( AuthenticationManagerBuilder auth, UserDetailsService userDetailsService )
            throws Exception {
        auth.userDetailsService ( userDetailsService  ).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
                    .loginPage ( "/login" )
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
                    .loginPage ( "/login" )
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
