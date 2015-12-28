package workshop.spring.security.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.jpa.domain.AbstractAuditable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * TimesheetEntry entity.
 */
@Entity
public class TimesheetEntry extends AbstractAuditable<User,Long> {

    private Date startDate;
    private Date endDate;
    private int lunchTime;

    @ManyToOne
    private Project project;

    public TimesheetEntry () {
    }

    public TimesheetEntry ( Date startDate, Date endDate, int lunchTime, Project project ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.lunchTime = lunchTime;
        this.project = project;
    }

    public Date getStartDate () {
        return startDate;
    }

    public Date getEndDate () {
        return endDate;
    }

    public int getLunchTime () {
        return lunchTime;
    }

    public Project getProject () {
        return project;
    }

    public void setStartDate ( Date startDate ) {
        this.startDate = startDate;
    }

    public void setEndDate ( Date endDate ) {
        this.endDate = endDate;
    }

    public void setLunchTime ( int lunchTime ) {
        this.lunchTime = lunchTime;
    }

    public long getTotalTime () {
        return Duration.between(
                LocalDateTime.from (startDate.toInstant ()),
                LocalDateTime.from (endDate.toInstant ())).minus(Duration.ofMinutes ( lunchTime ) ).toHours ();
    }

    public void setProject ( Project project ) {
        this.project = project;
    }

    @Override
    public String toString () {
        return new ToStringBuilder ( this, ToStringStyle.SIMPLE_STYLE )
                .appendSuper ( super.toString () )
                .append ( "startDate", startDate )
                .append ( "endDate", endDate )
                .append ( "lunchTime", lunchTime )
                .append ( "project", project )
                .toString ();
    }
}
