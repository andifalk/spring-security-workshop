package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;
import info.novatec.testit.webtester.pageobjects.PasswordField;
import info.novatec.testit.webtester.pageobjects.TextField;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
public class TodoLogin extends PageObject {

    @IdentifyUsing ( "username" )
    private TextField usernameField;

    @IdentifyUsing ( "password" )
    private PasswordField passwordField;

    @IdentifyUsing ( "loginButton" )
    private Button loginButton;

    @PostConstruct
    private void verifyLoginPageIsDisplayed () {
        assertThat ( "Should display login page", getBrowser ().getUrl (), is ( containsString ( "login" ) ) );
    }

    public TodoHomeUser loginExpectUserRole ( String username, String password) {
        return setUsername ( username ).setPassword ( password ).clickLoginExpectUserRole ();
    }

    public TodoHomeAdmin loginExpectAdminRole ( String username, String password) {
        return setUsername ( username ).setPassword ( password ).clickLoginExpectAdminRole ();
    }

    public TodoLogin loginExpectError (String username, String password) {
        return setUsername ( username ).setPassword ( password ).clickLoginExpectError ();
    }

    public TodoLogin setUsername ( String username) {
        usernameField.setText ( username );
        return this;
    }

    public TodoLogin setPassword ( String password) {
        passwordField.setText ( password );
        return this;
    }

    public TodoHomeUser clickLoginExpectUserRole () {
        loginButton.click ();
        return create ( TodoHomeUser.class );
    }

    public TodoHomeAdmin clickLoginExpectAdminRole () {
        loginButton.click ();
        return create ( TodoHomeAdmin.class );
    }

    public TodoLogin clickLoginExpectError () {
        loginButton.click ();
        return create ( TodoLogin.class );
    }
}
