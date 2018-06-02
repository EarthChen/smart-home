package cn.edu.smart.home.domain;

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
public class Role extends SuperEntity<Role> {

    private static final long serialVersionUID = -6607556180305364434L;

    private String name;
    private String value;

    private Set<Authority> authorities = new HashSet<>();
}
