package workshop.spring.security.service;

import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import workshop.spring.security.entity.Role;

import java.util.List;

/**
 * Service to manage {@link Role roles}.
 */
@Secured( "ROLE_USER" )
public interface RoleService {

    Role save ( Role role );

    Role findOne ( Long aLong );

    List<Role> findAll ( Sort sort );

    Role findOneByName ( String name );
}
