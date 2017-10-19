package app.service.certificate.web.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description
 */
public interface SecurityService {
    UserDetails getSecurityUser(String username);
}
