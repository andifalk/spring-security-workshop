package workshop.spring.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import workshop.spring.security.entity.Todo;
import workshop.spring.security.repository.TodoRepository;

import java.util.List;

/**
 * Implementation for {@link ToDoService}.
 */
@Service("todoService")
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> findAll () {
        return todoRepository.findAll ( new Sort ( "startDate" ) );
    }

    @Override
    public Todo save ( Todo entity ) {
        return todoRepository.save ( entity );
    }

    @Override
    public Todo findOne ( Long aLong ) {
        return todoRepository.findOne ( aLong );
    }
}
