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
import workshop.spring.security.pageobject.CreateToDo;
import workshop.spring.security.pageobject.ToDoList;
import workshop.spring.security.pageobject.TodoHomeUser;
import workshop.spring.security.pageobject.TodoLogin;

import javax.annotation.Resource;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
@RunWith ( WebTesterJUnitRunner.class )
public class ToDoWorkflowTest {

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
    public void verifyAddToDoWithRoleUser () {

        final TodoHomeUser todoHomeUser = todoLogin.login ( usernameRoleUser, passwordRoleUser );
        final ToDoList toDoList = todoHomeUser.navigateToTodoList ();
        final int numberOfToDoEntriesBeforeAddition = toDoList.numberOfToDoEntries ();

        final CreateToDo createToDo = toDoList.clickNewToDo ();

        createToDo.createNewToDo ( "subject" + Long.valueOf ( System.currentTimeMillis () ).toString (), "desc", new Date (), new Date (), 1 );

        final int numberOfToDoEntriesAfterAddition = toDoList.numberOfToDoEntries ();

        assertThat ( "Table should contain one additional entry",
                numberOfToDoEntriesAfterAddition - numberOfToDoEntriesBeforeAddition, is ( 1 ) );

    }

}
