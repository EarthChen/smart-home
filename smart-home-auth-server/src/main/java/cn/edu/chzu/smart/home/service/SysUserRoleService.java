package cn.edu.chzu.smart.home.service;

/**
 * @author: EarthChen
 * @date: 2018/06/04
 */

public interface SysUserRoleService {

    /**
     * 保存用户角色关系
     *
     * @param userId
     * @param roleId
     */
    void saveUserRole(long userId, long roleId);


    /**
     * 保存新的用户角色关系
     * <p>
     * 首先判断当前用户是否已经有该角色，没有则保存
     *
     * @param userId
     * @param roleId
     */
    void saveNewUserRole(long userId, long roleId);


}
