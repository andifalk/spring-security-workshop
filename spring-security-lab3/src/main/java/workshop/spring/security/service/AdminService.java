package workshop.spring.security.service;

import org.springframework.security.access.annotation.Secured;

/**
 * Created by AFA on 10.12.2015.
 */
public interface AdminService {

    @Secured ( "ADMIN" )
    String getAdminInfos();
}
