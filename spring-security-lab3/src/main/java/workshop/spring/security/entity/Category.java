package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Project entity.
 */
@Entity
public class Category extends AbstractAuditable<User,Long> {

    @NotNull
    @Size(min = 3, max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String name;

    public Category () {
    }

    public Category ( String name ) {
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .appendSuper ( super.toString () )
                .append ( "name", name )
                .toString ();
    }
}
