package app.dao.impl;

import app.dao.SecurityDao;
import app.domain.entity.Role;
import app.domain.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description 安全数据实现类
 */
@Service
public class SecurityDaoImpl implements SecurityDao{


    //todo: 需要根据数据库实际情况进行处理
    @Override
    public User getUserByName(String username) {
        User user = new User();
        user.setId("user_id");
        user.setUsername("root");
        user.setPassword("root");
        return user;
    }

    @Override
    public List<Role> getRoleByUserId(String userid) {
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setRolename("root");
        role.setRoleid("root");
        roles.add(role);
        return roles;
    }

    @Override
    public List<String> getAuthorityIdByRoleId(String roleid) {
        List<String> authortiy = new ArrayList<String>();
        authortiy.add("system");
        return authortiy;
    }

}
