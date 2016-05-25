package spring.workshop.oauth.resource;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Custom principal extractor.
 */
@Component
public class MyPrincipalExtractor implements PrincipalExtractor {
    private static final String[] PRINCIPAL_KEYS = new String[] { "username", "name" };

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        String userName = "n/a";
        for (String key : PRINCIPAL_KEYS) {
            if (map.containsKey(key)) {
                userName = (String) map.get(key);
                break;
            }
        }
        return new User(userName, (String) map.get ( "firstName" ), (String) map.get ( "lastName" ));
    }
}
