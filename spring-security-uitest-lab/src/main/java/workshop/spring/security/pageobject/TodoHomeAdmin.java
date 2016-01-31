package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Link;
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

    @IdentifyUsing ( "menuTodos" )
    private Link menuToDos;

    @IdentifyUsing ( "menuCategories" )
    private Link menuCategories;

    @IdentifyUsing ( "menuUsers" )
    private Link menuUsers;


    @PostConstruct
    private void verifyAdminHomePageIsDisplayed() {
        assertThat ( "Should display home page for user with role ADMIN",
                getBrowser ().getPageTitle (), is ( "Welcome to the ToDo tracker" ) );
        assertThat ( "Menu for ToDos should be visible", menuToDos.isVisible (), is ( true ) );
        assertThat ( "Menu for Categories should be visible", menuCategories.isVisible (), is ( true ) );
        assertThat ( "Menu for Users should be visible", menuUsers.isVisible (), is ( true ) );

    }

    public TodoLogin logout () {
        logoutLink.click ();
        return create ( TodoLogin.class );
    }

}
