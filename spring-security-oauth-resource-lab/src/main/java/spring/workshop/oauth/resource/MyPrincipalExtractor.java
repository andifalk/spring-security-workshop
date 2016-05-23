package spring.workshop.oauth.resource;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by AFA on 23.05.2016.
 */
@Component
public class MyPrincipalExtractor implements PrincipalExtractor {

    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        return new User((String)map.get("name"));
    }
}
