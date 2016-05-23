package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Role;
import workshop.spring.security.repository.RoleRepository;

import java.util.List;

/**
 * Implementation for {@link RoleService}.
 */
@Service( "roleService" )
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Secured( "ROLE_ADMIN" )
    @Transactional
    @Override
    public Role save ( Role role ) {
        return roleRepository.save ( role );
    }

    @Transactional(readOnly = true)
    @Override
    public Role findOne ( Long aLong ) {
        return roleRepository.findOne ( aLong );
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> findAll ( Sort sort ) {
        return roleRepository.findAll ( new Sort ( "name" ) );
    }

    @Transactional(readOnly = true)
    @Override
    public Role findOneByName ( String name ) {
        return roleRepository.findOneByName ( name );
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
