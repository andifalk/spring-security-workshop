package workshop.spring.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import workshop.spring.security.entity.Todo;

import java.util.List;

/**
 * Service to manage {@link Todo to do's}.
 */
@Secured( "ROLE_USER" )
public interface ToDoService {

    @Transactional(readOnly = true)
    List<Todo> findAll ();

    @Transactional
    Todo save ( Todo entity );

    @Transactional(readOnly = true)
    Todo findOne ( Long aLong );
}
