package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.api.enumerations.Caching;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.Link;
import info.novatec.testit.webtester.pageobjects.PageObject;
import info.novatec.testit.webtester.pageobjects.Table;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
public class ToDoList extends PageObject {

    @IdentifyUsing( "newToDoEntryButton" )
    private Link newToDoButton;

    @IdentifyUsing ( value = "todos", caching = Caching.OFF )
    private Table todoList;

    @PostConstruct
    private void verifyToDoListPageIsDisplayed() {
        assertThat ( "Should display ToDo home page", getBrowser ().getPageTitle (), is ( "To Do List" ) );
        assertThat ( "Button for creating new ToDos should be visible", newToDoButton.isVisible (), is ( true ) );
    }

    public CreateToDo clickNewToDo () {
        newToDoButton.click ();
        return create ( CreateToDo.class );
    }

    public int numberOfToDoEntries () {
        return todoList.getNumberOfRows ();
    }
}
