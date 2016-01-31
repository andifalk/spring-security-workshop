package workshop.spring.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import workshop.spring.security.entity.Category;
import workshop.spring.security.entity.Todo;
import workshop.spring.security.entity.User;
import workshop.spring.security.service.CategoryService;
import workshop.spring.security.service.ToDoService;
import workshop.spring.security.service.UserService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Controller for application web pages and models.
 */
@Controller
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger ( AppController.class );

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private UserService userService;

    @ModelAttribute("allUsers")
    public List<User> populatUsers() {
        return this.userService.findAll();
    }

    @ModelAttribute("allCategories")
    public List<Category> populatCategories() {
        return this.categoryService.findAll();
    }

    @ModelAttribute("allToDoEntries")
    public List<Todo> populateToDos() {
        return this.toDoService.findAll();
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/")
    public String index( Model model ) {
        final Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        if ( authentication != null ) {
            LOGGER.info ( "User '{}' authenticated with granted roles '{}'",
                    ((UserDetails) authentication.getPrincipal ()).getUsername (), authentication.getAuthorities () );
            model.addAttribute ( "username", "Hello " + ((UserDetails) authentication.getPrincipal ()).getUsername () );
        } else {
            model.addAttribute ( "username", "Hello unknown" );
        }
        return "index";
    }

    /**
     * Request mapping for categories web page.
     * @return web page
     */
    @RequestMapping(path = "/categories")
    public String categories() {
        return "categories";
    }

    /**
     * Request mapping for adding category web page.
     * @return web page
     */
    @RequestMapping(path = "/addcategory")
    public String addCategory( Model model) {
        model.addAttribute ( "category", new Category () );
        return "addcategory";
    }

    /**
     * Request mapping for storing category.
     * @return web page
     */
    @RequestMapping(value="/createcategory")
    public String createCategory(
            final Category category, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addcategory";
        }
        this.categoryService.save ( category );
        model.clear();
        return "redirect:/categories";
    }

    /**
     * Request mapping for todo's web page.
     * @return web page
     */
    @RequestMapping(path = "/todo")
    public String todo() {
        return "todo";
    }

    /**
     * Request mapping for adding todo web page.
     * @return web page
     */
    @RequestMapping(path = "/addtodo")
    public String addToDo( Model model) {
        model.addAttribute ( "todo", new Todo () );
        return "addtodo";
    }

    /**
     * Request mapping for storing todo.
     * @return web page
     */
    @RequestMapping(value="/createtodo")
    public String createTodo(
            final Todo todo, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            LOGGER.info ( "Error creating TODO: {}", bindingResult.getAllErrors () );
            return "addtodo";
        }

        try {
            this.toDoService.save ( todo );
            model.clear ();
            model.addAttribute ( "allToDoEntries", this.toDoService.findAll());
            return "/todo";
            //return "redirect:/todo";
        } catch ( ConstraintViolationException ex ) {
            final ConstraintViolation<?> constraintViolation = ex.getConstraintViolations ().iterator ().next ();
            model.addAttribute ( "error", constraintViolation.getPropertyPath ().toString () + ": " + constraintViolation.getMessage () );
            return "addToDo";
        }
    }

    /**
     * Request mapping for user web page.
     * @return web page
     */
    @RequestMapping(path = "/users")
    public String users() {
        return "users";
    }

    /**
     * Request mapping for adding user web page.
     * @return web page
     */
    @RequestMapping(path = "/adduser")
    public String addUser( Model model) {
        model.addAttribute ( "user", new User () );
        return "adduser";
    }

    /**
     * Request mapping for storing user.
     * @return web page
     */
    @RequestMapping(value="/createuser")
    public String createUser(
            final User user, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "adduser";
        }
        this.userService.save ( user );
        model.clear();
        return "redirect:/users";
    }
}
