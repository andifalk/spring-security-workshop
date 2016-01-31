package workshop.spring.security.test;

import info.novatec.testit.webtester.api.browser.Browser;
import info.novatec.testit.webtester.browser.factories.FirefoxFactory;
import info.novatec.testit.webtester.junit.annotations.ConfigurationValue;
import info.novatec.testit.webtester.junit.annotations.CreateUsing;
import info.novatec.testit.webtester.junit.annotations.EntryPoint;
import info.novatec.testit.webtester.junit.runner.WebTesterJUnitRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import workshop.spring.security.pageobject.TodoHomeAdmin;
import workshop.spring.security.pageobject.TodoHomeUser;
import workshop.spring.security.pageobject.TodoLogin;

import javax.annotation.Resource;

/**
 * Created by AFA on 24.01.2016.
 */
@RunWith ( WebTesterJUnitRunner.class )
public class LoginTest {

    @Resource
    @CreateUsing ( FirefoxFactory.class )
    @EntryPoint ( "http://localhost:8080" )
    private Browser browser;

    @ConfigurationValue ( "todo.user.username" )
    private String usernameRoleUser;
    @ConfigurationValue ( "todo.user.password" )
    private String passwordRoleUser;
    @ConfigurationValue ( "todo.admin.username" )
    private String usernameRoleAdmin;
    @ConfigurationValue ( "todo.admin.password" )
    private String passwordRoleAdmin;

    private TodoLogin todoLogin;

    @Before
    public void initStartPage () {
        todoLogin = browser.create ( TodoLogin.class );
    }

    @Test
    public void verifyLoginUserWithRoleUser () {

        final TodoHomeUser todoHomeUser = todoLogin.loginExpectUserRole ( usernameRoleUser, passwordRoleUser );
        todoHomeUser.logout ();
    }

    @Test
    public void verifyLoginUserWithRoleAdmin () {

        final TodoHomeAdmin todoHomeAdmin = todoLogin.loginExpectAdminRole ( usernameRoleAdmin, passwordRoleAdmin );
        todoHomeAdmin.logout ();
    }

    @Test
    public void verifyLoginUserFailure () {

        todoLogin.loginExpectError ( "dummy", "dummy" );
    }

}
