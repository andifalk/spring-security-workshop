package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.PageObject;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
public class TodoHomeAdmin extends TodoHomeUser {

    @IdentifyUsing ( "logoutButton" )
    private Button logoutLink;

    @PostConstruct
    private void verifyLoginPageIsDisplayed() {
        assertThat ( "Should display login page", getBrowser ().getPageTitle (), is ( "Welcome to the ToDo tracker" ) );
    }

    public TodoLogin logout () {
        logoutLink.click ();
        return create ( TodoLogin.class );
    }

}
