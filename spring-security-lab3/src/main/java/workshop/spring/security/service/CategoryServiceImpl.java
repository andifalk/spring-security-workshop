package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.Category;
import workshop.spring.security.repository.CategoryRepository;

import java.util.List;

/**
 * Implementation for {@link CategoryService}.
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll () {
        return categoryRepository.findAll ();
    }

    @Override
    public Category save ( Category entity ) {
        return categoryRepository.save ( entity );
    }

    @Override
    public Category findOne ( Long aLong ) {
        return categoryRepository.findOne ( aLong );
    }
}
