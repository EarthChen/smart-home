package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.SysUser;
import org.springframework.stereotype.Repository;

/**
 * userdao
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Repository
public interface SysUserDao extends SuperMapper<SysUser> {

    /**
     * 根据username查找用户和角色
     *
     * @param username
     * @return
     */
    SysUser findOneWithRolesByUsername(String username);


    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    SysUser findOneByUsername(String username);
}
