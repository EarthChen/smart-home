package cn.edu.chzu.smart.home.domain;

/**
 * 角色权限表
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
public class SysRoleAuthority extends SuperEntity<SysRoleAuthority> {


    private static final long serialVersionUID = 949118747637704695L;

    /**
     * 角色id
     */
    private Long roleId;


    /**
     * 权限id
     */
    private Long authorityId;
}
