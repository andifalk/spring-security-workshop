package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;

/**
 * Project entity.
 */
@Entity
public class Project extends AbstractAuditable<User,Long> {

    private String name;
    private boolean active;

    public Project () {
    }

    public Project ( String name, boolean active ) {
        this.name = name;
        this.active = active;
    }

    public String getName () {
        return name;
    }

    public boolean isActive () {
        return active;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public void setActive ( boolean active ) {
        this.active = active;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .appendSuper ( super.toString () )
                .append ( "name", name )
                .append ( "active", active )
                .toString ();
    }
}
