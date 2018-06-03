package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.domain.user.SysUser;

/**
 * user服务
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param sysUser
     */
    void createUser(SysUser sysUser);
}
