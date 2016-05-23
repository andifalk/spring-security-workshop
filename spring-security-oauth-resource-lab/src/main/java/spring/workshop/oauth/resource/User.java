package spring.workshop.oauth.resource;

import java.security.Principal;

/**
 * Created by AFA on 23.05.2016.
 */
public class User implements Principal {

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
