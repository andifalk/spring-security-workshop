package workshop.spring.security.service;

import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Project;

import java.util.List;

/**
 * Service for managing {@link Project projects}.
 */
public interface ProjectService {

    @Transactional(readOnly = true)
    List<Project> findAll ();

    @Transactional
    Project save ( Project entity );

    @Transactional(readOnly = true)
    Project findOne ( Long aLong );
}
