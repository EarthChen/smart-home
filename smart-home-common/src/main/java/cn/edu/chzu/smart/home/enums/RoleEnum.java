package cn.edu.chzu.smart.home.enums;

import lombok.Getter;

/**
 * 角色枚举
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Getter
public enum RoleEnum {

    /**
     * 管理员
     */
    ROLE_ADMIN(1L, "管理员"),

    /**
     * 普通用户
     */
    ROLE_USER(2L, "普通用户"),;

    private Long roleId;

    private String roleName;

    RoleEnum(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }


}
