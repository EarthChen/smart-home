package cn.edu.smart.home.service.impl;

import cn.edu.smart.home.domain.User;
import cn.edu.smart.home.service.UserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;

/**
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService, UserService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = User.builder().build();
        return user;
//        Optional<SysUser> realUser = sysUserRepository.findOneWithRolesByUsername(lowcaseUsername);
//
//
//
//        return realUser.map(user -> {
//            Set<GrantedAuthority> grantedAuthorities = user.getAuthorities();
//            return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
//        }).orElseThrow(() -> new UsernameNotFoundException("用户" + lowcaseUsername + "不存在!"));
    }
}
