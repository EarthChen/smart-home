package cn.edu.chzu.smart.home.key.auth;

import cn.edu.chzu.smart.home.key.BasePrefix;

/**
 * sysuser的rediskey
 *
 * @author: EarthChen
 * @date: 2018/06/05
 */
public class SysUserKey extends BasePrefix {

    private SysUserKey(String prefix) {
        super(prefix);
    }

    private SysUserKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static SysUserKey getById = new SysUserKey("id");
    public static SysUserKey getByUsernameWithExpire= new SysUserKey(43200, "username");
}
