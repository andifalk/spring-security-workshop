package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Role entity.
 */
@Entity
public class Role extends AbstractPersistable<Long> {

    @NotNull
    @Size(min = 3, max = 50)
    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @SuppressWarnings ( "unused" )
    public Role () {
    }

    public Role ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    @Override
    public boolean equals ( Object o ) {
        if ( this == o ) return true;

        if ( o == null || getClass () != o.getClass () ) return false;

        Role role = (Role) o;

        return new EqualsBuilder ()
                .appendSuper ( super.equals ( o ) )
                .append ( name, role.name )
                .isEquals ();
    }

    @Override
    public int hashCode () {
        return new HashCodeBuilder ( 17, 37 )
                .appendSuper ( super.hashCode () )
                .append ( name )
                .toHashCode ();
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .append ( "name", name )
                .toString ();
    }
}
