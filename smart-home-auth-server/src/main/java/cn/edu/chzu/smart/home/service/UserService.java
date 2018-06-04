package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.form.RegisterForm;
import cn.edu.chzu.smart.home.vo.RegisterVO;

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


    /**
     * 注册新用户
     * <p>
     * 首先给用户赋为普通用户
     *
     * @param registerForm
     * @return
     */
    RegisterVO registerUser(RegisterForm registerForm);
}
