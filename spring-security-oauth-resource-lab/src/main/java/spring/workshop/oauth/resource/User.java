package spring.workshop.oauth.resource;

import java.security.Principal;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by AFA on 23.05.2016.
 */
public class User implements Principal {

    private String name;

    private String firstName;

    private String lastName;

    public User ( String name, String firstName, String lastName ) {
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getFirstName () {
        return firstName;
    }

    public void setFirstName ( String firstName ) {
        this.firstName = firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public void setLastName ( String lastName ) {
        this.lastName = lastName;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this )
                .append ( "name", name )
                .append ( "firstName", firstName )
                .append ( "lastName", lastName )
                .toString ();
    }
}
