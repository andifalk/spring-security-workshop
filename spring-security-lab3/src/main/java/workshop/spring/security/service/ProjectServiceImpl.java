package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.Project;
import workshop.spring.security.repository.ProjectRepository;

import java.util.List;

/**
 * Implementation for {@link ProjectService}.
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAll () {
        return projectRepository.findAll ();
    }

    @Override
    public Project save ( Project entity ) {
        return projectRepository.save ( entity );
    }

    @Override
    public Project findOne ( Long aLong ) {
        return projectRepository.findOne ( aLong );
    }
}
