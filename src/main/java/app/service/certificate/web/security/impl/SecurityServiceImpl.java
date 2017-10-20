package app.service.certificate.web.security.impl;

import app.dao.SecurityDao;
import app.domain.entity.Role;
import app.domain.entity.SecurityUser;
import app.domain.entity.User;
import app.service.certificate.web.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description
 */
@Service
@Component
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    SecurityDao securityDao;

    @Override
    public UserDetails getSecurityUser(String username) {
        User user = securityDao.getUserByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("no user");
        }

        List<String> authority = new ArrayList<String>();

        List<Role> roles = securityDao.getRoleByUserId(user.getId());

        for(Role role : roles) {
            authority.addAll(securityDao.getAuthorityIdByRoleId(role.getRoleid()));
        }

        SecurityUser securityUser = new SecurityUser(user, authority);
        return securityUser.getAuthorUser();
    }
}
