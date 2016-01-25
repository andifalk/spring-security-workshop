package workshop.spring.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Category;

import java.util.List;

/**
 * Service for managing {@link Category categories}.
 */
@Secured( "ROLE_USER" )
public interface CategoryService {

    @Transactional(readOnly = true)
    List<Category> findAll ();

    @Secured( "ROLE_ADMIN" )
    @Transactional
    Category save ( Category entity );

    @Transactional(readOnly = true)
    Category findOne ( Long aLong );
}
