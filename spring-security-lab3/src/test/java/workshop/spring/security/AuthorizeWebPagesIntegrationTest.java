package workshop.spring.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSecurityLab3Application.class)
@WebAppConfiguration
public class AuthorizeWebPagesIntegrationTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void verifyRootPathNotAuthenticated() throws Exception {
        this.mvc
                .perform ( get( "/" ) )
                .andExpect ( status ().isFound () )
                .andExpect ( redirectedUrlPattern ( "**/login" ) );
    }

    @Test
    public void verifyRootPathAuthorizeAdminOK() throws Exception {
        this.mvc
                .perform ( get( "/" ).with(user("admin").password("admin").roles("ADMIN") ) )
                .andExpect ( status ().isOk () );
    }

    @Test
    public void verifyRootPathAuthorizeUserOK() throws Exception {
        this.mvc
                .perform ( get( "/" ).with(user("user").password("password").roles("USER") ) )
                .andExpect ( status ().isOk () );
    }

    @Test
    public void verifyUsersPathAuthorizeAdminOK() throws Exception {
        this.mvc
                .perform ( get( "/users" ).with(user("admin").password("admin").roles("ADMIN") ) )
                .andExpect ( status ().isOk () );
    }

    @Test
    public void verifyUsersPathAuthorizeUserNotOK() throws Exception {
        this.mvc
                .perform ( get( "/users" ).with(user("user").password("user").roles("USER") ) )
                .andExpect ( status ().isForbidden () );
    }

    @Test
	public void verifyCategoriesPathAuthorizeAdminOK() throws Exception {
        this.mvc
                .perform ( get( "/categories" ).with(user("admin").password("admin").roles("ADMIN") ) )
                .andExpect ( status ().isOk () );
	}

    @Test
    public void verifyCategoriesPathAuthorizeUserNotOK() throws Exception {
        this.mvc
                .perform ( get( "/categories" ).with(user("user").password("user").roles("USER") ) )
                .andExpect ( status ().isForbidden () );
    }

    @Test
    public void verifyTodoPathAuthorizeUserOK() throws Exception {
        this.mvc
                .perform ( get( "/todo" ).with(user("user").password("user").roles("USER") ) )
                .andExpect ( status ().isOk () );
    }

    @Test
    public void verifyTodoPathAuthorizeAdminOK() throws Exception {
        this.mvc
                .perform ( get( "/todo" ).with(user("admin").password("admin").roles("ADMIN") ) )
                .andExpect ( status ().isOk () );
    }

}
