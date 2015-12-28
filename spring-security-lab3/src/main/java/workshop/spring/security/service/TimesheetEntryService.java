package workshop.spring.security.service;

import workshop.spring.security.entity.TimesheetEntry;

import java.util.List;

/**
 * Created by AFA on 28.12.2015.
 */
public interface TimesheetEntryService {
    List<TimesheetEntry> findAll ();

    TimesheetEntry save ( TimesheetEntry entity );

    TimesheetEntry findOne ( Long aLong );
}
