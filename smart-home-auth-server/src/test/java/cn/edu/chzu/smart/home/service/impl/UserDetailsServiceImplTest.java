package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.form.RegisterForm;
import cn.edu.chzu.smart.home.service.UserService;
import cn.edu.chzu.smart.home.vo.RegisterVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Slf4j
public class UserDetailsServiceImplTest extends ApplicationTests {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Test
    public void registerUser() {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setUsername("test");
        registerForm.setPassword("123456");
        registerForm.setRepeatPassword("123456");
        registerForm.setEmail("123@163.com");
        RegisterVO sysUser = userService.registerUser(registerForm);
        log.info(sysUser.toString());
    }
}