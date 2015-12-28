package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.Role;
import workshop.spring.security.repository.RoleRepository;

import java.util.List;

/**
 * Implementation for {@link RoleService}.
 */
@Service( "roleService" )
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role save ( Role role ) {
        return roleRepository.save ( role );
    }

    @Override
    public Role findOne ( Long aLong ) {
        return roleRepository.findOne ( aLong );
    }

    @Override
    public List<Role> findAll ( Sort sort ) {
        return roleRepository.findAll ( new Sort ( "name" ) );
    }

    @Override
    public Role findOneByName ( String name ) {
        return roleRepository.findOneByName ( name );
    }
}
