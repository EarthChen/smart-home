package cn.edu.smart.home.domain.user;

import lombok.Data;

/**
 * 用户角色表
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Data
public class SysUserRole extends SuperEntity<SysUserRole> {

    private static final long serialVersionUID = 985204389752547404L;

    /**
     * 用户id
     */
    private Long userId;


    /**
     * 角色id
     */
    private Long roleId;
}
