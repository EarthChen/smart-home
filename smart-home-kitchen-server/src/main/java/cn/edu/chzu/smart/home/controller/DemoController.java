package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.user.SysUser;
import cn.edu.chzu.smart.home.util.LoginUserUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author: EarthChen
 * @date: 2018/06/03
 */
@RestController
public class DemoController {

    @GetMapping("/demo")
    @PreAuthorize("hasAuthority('query')")
    public Object getDemo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        System.out.println(authentication.getAuthorities());
        return authentication;
    }


    @GetMapping("/demo2")
    @PreAuthorize("hasAuthority('query2')")
    public String getDemo2() {
        return "good";
    }


    @GetMapping("/demo3")
    @PreAuthorize("hasAuthority('query3')")
    public String getDemo3() {
        return "good";
    }

}
