package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.TimesheetEntry;
import workshop.spring.security.repository.TimesheetEntryRepository;

import java.util.List;

/**
 * Implementation for {@link TimesheetEntryService}.
 */
@Service("timesheetEntryService")
public class TimesheetEntryServiceImpl implements TimesheetEntryService {

    @Autowired
    private TimesheetEntryRepository timesheetEntryRepository;

    @Override
    public List<TimesheetEntry> findAll () {
        return timesheetEntryRepository.findAll ( new Sort ( "startDate" ) );
    }

    @Override
    public TimesheetEntry save ( TimesheetEntry entity ) {
        return timesheetEntryRepository.save ( entity );
    }

    @Override
    public TimesheetEntry findOne ( Long aLong ) {
        return timesheetEntryRepository.findOne ( aLong );
    }
}
