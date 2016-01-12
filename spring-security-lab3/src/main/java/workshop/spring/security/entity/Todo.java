package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * TimesheetEntry entity.
 */
@Entity
public class Todo extends AbstractAuditable<User,Long> {

    @NotNull
    @Size(min = 3, max = 30)
    @Column(length = 30, nullable = false, unique = true)
    private String subject;

    @Size(max = 1000)
    @Column(length = 1000)
    private String description;

    @Temporal ( TemporalType.DATE )
    private Date startDate;

    @Temporal ( TemporalType.DATE )
    private Date dueDate;

    @ManyToOne
    private Category category;

    public Todo () {
    }

    public Todo ( String subject, String description, Date startDate, Date dueDate, Category category ) {
        this.subject = subject;
        this.description = description;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.category = category;
    }

    public String getSubject () {
        return subject;
    }

    public void setSubject ( String subject ) {
        this.subject = subject;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription ( String description ) {
        this.description = description;
    }

    public Date getStartDate () {
        return startDate;
    }

    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    public Date getDueDate () {
        return dueDate;
    }

    public void setDueDate ( Date dueDate ) {
        this.dueDate = dueDate;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory ( Category category ) {
        this.category = category;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .appendSuper ( super.toString () )
                .append ( "subject", subject )
                .append ( "description", description )
                .append ( "startDate", startDate )
                .append ( "dueDate", dueDate )
                .append ( "category", category )
                .toString ();
    }
}
