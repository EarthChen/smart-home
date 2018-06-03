package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.dao.auth.SysAuthorityDao;
import cn.edu.chzu.smart.home.dao.auth.SysRoleDao;
import cn.edu.chzu.smart.home.dao.auth.SysUserDao;
import cn.edu.chzu.smart.home.domain.user.SysRole;
import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.enums.ResultEnum;
import cn.edu.chzu.smart.home.exception.AuthException;
import cn.edu.chzu.smart.home.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;


/**
 * 实现UserDetailsService
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {


    @Autowired
    private SysUserDao sysUserDao;


    /**
     * 密码加密类
     */
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserDao.findOneWithRolesByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException(username);
        }
        Set<GrantedAuthority> grantedAuthorities = sysUser.getAuthorities();
        return new User(sysUser.getUsername(), sysUser.getPassword(), grantedAuthorities);
    }

    @Override
    public void createUser(SysUser sysUser) {

        SysUser existUser = sysUserDao.findOneByUsername(sysUser.getUsername());
        if (existUser == null) {
            throw new AuthException(ResultEnum.CURRENT_USER_ALREADY_EXIST);
        }
        // 给密码加密
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));

        int success = sysUserDao.insert(sysUser);
        if (success != 1) {
            throw new AuthException(ResultEnum.SAVE_USER_ERROR);
        }
    }
}
