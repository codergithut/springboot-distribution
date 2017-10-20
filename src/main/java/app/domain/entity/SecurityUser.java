package app.domain.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description 用户信息初始化并返回UserDetail实例
 */
public class SecurityUser{

    private User user;

    private List<String> authorityEntities;

    public SecurityUser(User user, List<String> authorityEntities) {
        this.user = user;
        this.authorityEntities = authorityEntities;
    }

    public UserDetails getAuthorUser() {
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        for(String authorityEntity : authorityEntities) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authorityEntity);
            roles.add(grantedAuthority);
        }
        org.springframework.security.core.userdetails.User detailUser =
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        roles
                );

        return detailUser;
    }
}
