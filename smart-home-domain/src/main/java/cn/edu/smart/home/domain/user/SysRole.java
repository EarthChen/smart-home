package cn.edu.smart.home.domain.user;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class SysRole extends SuperEntity<SysRole> {

    private static final long serialVersionUID = -6607556180305364434L;

    /**
     * 角色名
     */
    private String name;

    /**
     * 意义
     */
    private String value;

    private Set<SysAuthority> authorities = new HashSet<>();
}
