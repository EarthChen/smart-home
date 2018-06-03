package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.util.LoginUserUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 用户控制器
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@RestController
public class UserController {

    @GetMapping("/user")
    public Object user(Principal user) {
        return user;
    }
}
