package cn.edu.chzu.smart.home.util;

import cn.edu.chzu.smart.home.domain.user.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 * 登录用户工具类
 *
 * @author: EarthChen
 * @date: 2018/03/16
 */
public class LoginUserUtil {


    public static SysUser load() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal != null && principal instanceof SysUser) {
            return (SysUser) principal;
        }
        return null;
    }

    /**
     * 获取登录用户id
     *
     * @return
     */
    public static Long getLoginUserId() {
        SysUser user = load();
        if (user == null) {
            return -1L;
        }
        return user.getId();
    }

}
