package app.dao;

import app.domain.entity.Role;
import app.domain.entity.User;

import java.util.List;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/10/16
 * @description
 */
public interface SecurityDao {
    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 根据用户提供的信息获取用户信息（用户验证）
     */
    User getUserByName(String username);

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 根据用户id获取角色对象
     */
    List<Role> getRoleByUserId(String userid);

    /**
     * @author <a href="mailto:tianjian@gtmap.cn">tianjian</a>
     * @param
     * @return
     * @description 根据roleid获取权限信息
     */
    List<String> getAuthorityIdByRoleId(String roleid);
}
