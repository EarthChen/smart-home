package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.form.RegisterForm;
import cn.edu.chzu.smart.home.service.UserService;
import cn.edu.chzu.smart.home.vo.RegisterVO;
import cn.edu.chzu.smart.home.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

/**
 * 用户控制器
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @GetMapping("/current")
    public Object user(Principal user) {
        return user;
    }

    @GetMapping("/me")
    public ResultVO me() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResultVO.success(principal);
    }

    /**
     * 注册
     *
     * @param registerForm
     * @return
     */
    @PostMapping("/register")
    public ResultVO register(@Valid RegisterForm registerForm) {
        RegisterVO registerVO = userService.registerUser(registerForm);
        return ResultVO.success(registerVO);
    }
}
