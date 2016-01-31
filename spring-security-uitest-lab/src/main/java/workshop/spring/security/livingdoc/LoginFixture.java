package workshop.spring.security.livingdoc;

/**
 * Created by AFA on 24.01.2016.
 */
public class LoginFixture {

    private String username;

    private String password;

    public void setUsername ( String username ) {
        this.username = username;
    }

    public void setPassword ( String password ) {
        this.password = password;
    }

    public String authenticatedAs () {
        return "USER";
    }


}
