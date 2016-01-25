package workshop.spring.security.service;

import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Role;

import java.util.List;

/**
 * Service to manage {@link Role roles}.
 */
@Secured( "ROLE_USER" )
public interface RoleService {

    @Secured( "ROLE_ADMIN" )
    @Transactional
    Role save ( Role role );

    @Transactional(readOnly = true)
    Role findOne ( Long aLong );

    @Transactional(readOnly = true)
    List<Role> findAll ( Sort sort );

    @Transactional(readOnly = true)
    Role findOneByName ( String name );
}
