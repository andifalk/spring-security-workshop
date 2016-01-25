package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Link;
import info.novatec.testit.webtester.pageobjects.PageObject;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
public class TodoHomeUser extends PageObject {

    @IdentifyUsing ( "logoutButton" )
    private Button logoutLink;

    @IdentifyUsing ( "menuTodos" )
    private Link menuToDos;

    @PostConstruct
    private void verifyHomePageIsDisplayed() {
        assertThat ( "Should display ToDo home page", getBrowser ().getPageTitle (), is ( "Welcome to the ToDo tracker" ) );
        assertThat ( "Menu for ToDos should be visible", menuToDos.isVisible (), is ( true ) );
    }

    public TodoLogin logout () {
        logoutLink.click ();
        return create ( TodoLogin.class );
    }

    public ToDoList navigateToTodoList () {
        menuToDos.click ();
        return create ( ToDoList.class );
    }

}
