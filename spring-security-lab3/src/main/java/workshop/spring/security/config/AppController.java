package workshop.spring.security.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.spring.security.entity.Project;
import workshop.spring.security.entity.TimesheetEntry;
import workshop.spring.security.service.ProjectService;
import workshop.spring.security.service.TimesheetEntryService;

import java.util.List;

/**
 * Created by AFA on 09.12.2015.
 */
@Controller
public class AppController {

    private static final Logger LOGGER = LoggerFactory.getLogger ( AppController.class );

    @Autowired
    private ProjectService projectService;

    @Autowired
    private TimesheetEntryService timesheetEntryService;

    @ModelAttribute("allProjects")
    public List<Project> populatProjects() {
        return this.projectService.findAll();
    }

    @ModelAttribute("allTimesheetEntries")
    public List<TimesheetEntry> populateTimesheetEntries() {
        return this.timesheetEntryService.findAll();
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/")
    public String index( Model model ) {
        final Authentication authentication = SecurityContextHolder.getContext ().getAuthentication ();
        if ( authentication != null ) {
            LOGGER.info ( "Granted roles are: {}", authentication.getAuthorities () );
            model.addAttribute ( "username", "Hello " + ((UserDetails) authentication.getPrincipal ()).getUsername () );
        } else {
            model.addAttribute ( "username", "Hello unknown" );
        }
        return "index";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/projects")
    public String projects() {
        return "projects";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/addproject")
    public String addProject( Model model) {
        model.addAttribute ( "project", new Project () );
        return "addproject";
    }

    @RequestMapping(value="/createproject")
    public String createProject(
            final Project project, final BindingResult bindingResult, final ModelMap model) {
        if (bindingResult.hasErrors()) {
            return "addproject";
        }
        this.projectService.save (project);
        model.clear();
        return "redirect:/projects";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/timesheet")
    public String timesheet() {
        return "timesheet";
    }

    /**
     * Restful service.
     * @return message
     */
    @RequestMapping(path = "/users")
    public String users() {
        return "users";
    }
}
