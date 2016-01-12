package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * User entity.
 */
@Entity
public class User extends AbstractPersistable<Long> implements UserDetails, CredentialsContainer {

    @NotNull
    @Size(min = 3, max = 30)
    @Column(unique = true, length = 30, nullable = false)
    private String username;

    @NotNull
    @Size(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String password;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, nullable = false)
    private String lastName;

    @NotNull
    @Column(nullable = false)
    private boolean active = true;

    @NotNull
    @Valid
    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.REFRESH )
    private Set<Role> roles = new HashSet<> ();

    @SuppressWarnings ( "unused" )
    public User () {
    }

    public User ( String username, String password, String firstName, String lastName, Set<Role> roles, boolean active ) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.active = active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities () {
        return roles
                .stream ()
                .map ( (Function<Role, GrantedAuthority>) role -> new SimpleGrantedAuthority ( "ROLE_" + role.getName () ) )
                .collect( Collectors.toSet());

    }

    @Override
    public String getPassword () {
        return password;
    }

    public String getUsername () {
        return username;
    }

    @Override
    public boolean isAccountNonExpired () {
        return true;
    }

    @Override
    public boolean isAccountNonLocked () {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired () {
        return true;
    }

    @Override
    public boolean isEnabled () {
        return this.active;
    }

    @Override
    public void eraseCredentials () {
        this.password = null;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public Set<Role> getRoles () {
        return roles;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .appendSuper ( super.toString () )
                .append ( "username", username )
                .append ( "firstName", firstName )
                .append ( "lastName", lastName )
                .append ( "roles", roles )
                .append ( "active", active )
                .toString ();
    }

}
