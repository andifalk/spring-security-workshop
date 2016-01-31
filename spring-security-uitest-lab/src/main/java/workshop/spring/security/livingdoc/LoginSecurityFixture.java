package workshop.spring.security.livingdoc;

/**
 * Created by AFA on 24.01.2016.
 */
public class LoginSecurityFixture {

    private String scenario;

    public void setScenario ( String scenario ) {
        this.scenario = scenario;
    }

    public boolean secure () {
        return true;
    }


}
