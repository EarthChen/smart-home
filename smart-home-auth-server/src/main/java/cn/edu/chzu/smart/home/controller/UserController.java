package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.SysUser;
import cn.edu.chzu.smart.home.form.RegisterForm;
import cn.edu.chzu.smart.home.key.auth.SysUserKey;
import cn.edu.chzu.smart.home.service.RedisService;
import cn.edu.chzu.smart.home.service.UserService;
import cn.edu.chzu.smart.home.vo.RegisterVO;
import cn.edu.chzu.smart.home.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;

/**
 * 用户控制器
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "User", tags = {"User"}, description = "用户相关")
public class UserController {


    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired
    private RedisService redisService;


    /**
     * 当前用户信息
     * <p>
     * 供其他服务调用获取权限信息
     * <p>
     * 1. 首先判断缓存中是否有sysuser
     * <p>
     * 2. 没有则根据用户名查出sysuser，并放入缓存
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "获取当前用户认证信息", httpMethod = "GET", response = Principal.class)
    @GetMapping("/current")
    public Object user(Principal user) {
        boolean exist = redisService.exists(SysUserKey.getByUsernameWithExpire, user.getName());
        if (!exist) {
            SysUser sysUser = userService.getSysUserByUsername(user.getName());
            boolean success = redisService.set(SysUserKey.getByUsernameWithExpire, user.getName(), sysUser);
            if (!success) {
                log.warn("SysUser放入缓存失败---time=" + new Date());
            }
        }
        return user;
    }


    /**
     * 获取当前登录用户信息
     * <p>
     * 1. 首先在缓存中取用户信息
     * <p>
     * 2. 如果没有则在数据库中查询
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "获取当前用户详细信息", httpMethod = "GET")
    @GetMapping("/me")
    public ResultVO<SysUser> me(Principal user) {
        SysUser sysUser = redisService.get(SysUserKey.getByUsernameWithExpire, user.getName(), SysUser.class);
        if (sysUser == null) {
            sysUser = userService.getSysUserByUsername(user.getName());
        }
        return ResultVO.success(sysUser);
    }

    /**
     * 注册
     *
     * @param registerForm
     * @return
     */
    @PostMapping("/register")
    @ApiOperation(value = "用户注册", httpMethod = "POST")
    public ResultVO<RegisterVO> register(@RequestBody @Valid RegisterForm registerForm) {
        RegisterVO registerVO = userService.registerUser(registerForm);
        return ResultVO.success(registerVO);
    }
}
