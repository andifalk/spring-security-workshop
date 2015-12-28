package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

/**
 * Role entity.
 */
@Entity
public class Role extends AbstractPersistable<Long> {

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
