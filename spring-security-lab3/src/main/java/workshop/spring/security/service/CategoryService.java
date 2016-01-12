package workshop.spring.security.service;

import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Category;

import java.util.List;

/**
 * Service for managing {@link Category categories}.
 */
public interface CategoryService {

    @Transactional(readOnly = true)
    List<Category> findAll ();

    @Transactional
    Category save ( Category entity );

    @Transactional(readOnly = true)
    Category findOne ( Long aLong );
}
