package workshop.spring.security.pageobject;

import info.novatec.testit.webtester.api.annotations.IdentifyUsing;
import info.novatec.testit.webtester.pageobjects.Button;
import info.novatec.testit.webtester.pageobjects.GenericElement;
import info.novatec.testit.webtester.pageobjects.PageObject;
import info.novatec.testit.webtester.pageobjects.Select;
import info.novatec.testit.webtester.pageobjects.TextArea;
import info.novatec.testit.webtester.pageobjects.TextField;

import javax.annotation.PostConstruct;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by AFA on 24.01.2016.
 */
public class CreateToDo extends PageObject {

    @IdentifyUsing ( "subject" )
    private TextField subjectField;

    @IdentifyUsing ( "description" )
    private TextArea descriptionField;

    @IdentifyUsing ( "startDate" )
    private GenericElement startDateField;

    @IdentifyUsing ( "dueDate" )
    private GenericElement dueDateField;

    @IdentifyUsing ( "category" )
    private Select categoryField;

    @IdentifyUsing( "saveToDoButton" )
    private Button saveButton;

    @IdentifyUsing( "cancelButton" )
    private Button cancelButton;

    @PostConstruct
    private void verifyLoginPageIsDisplayed() {
        assertThat ( "Should display create ToDo page", getBrowser ().getPageTitle (), is ( "New To Do" ) );
        assertThat ( "Button for saving ToDo should be visible", saveButton.isVisible (), is ( true ) );
    }

    public ToDoList createNewToDo ( String subject, String description, Date startDate, Date dueDate, int categoryIndex ) {
        return setSubject ( subject )
                .setDescription ( description )
                .setStartDate ( startDate )
                .setDueDate ( dueDate )
                .selectCategory ( categoryIndex )
                .saveToDo ();
    }

    public CreateToDo setSubject ( String subject ) {
        subjectField.setText ( subject );
        return this;
    }

    public CreateToDo setDescription ( String description ) {
        descriptionField.setText ( description );
        return this;
    }

    public CreateToDo setStartDate ( Date startDate ) {
        startDateField.sendKeys ( new SimpleDateFormat ( "yyyy-MM-dd").format ( startDate ) );
        return this;
    }

    public CreateToDo setDueDate ( Date dueDate ) {
        dueDateField.sendKeys ( new SimpleDateFormat ( "yyyy-MM-dd").format ( dueDate ) );
        return this;
    }

    public CreateToDo selectCategory ( int index ) {
        categoryField.selectByIndex ( index );
        return this;
    }

    public CreateToDo selectCategory ( String categoryName ) {
        categoryField.selectByText ( categoryName );
        return this;
    }

    public ToDoList saveToDo () {
        saveButton.click ();
        return create ( ToDoList.class );
    }

    public ToDoList cancel () {
        cancelButton.click ();
        return create ( ToDoList.class );
    }
}
