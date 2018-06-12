package cn.edu.chzu.smart.home.domain.auth;

import cn.edu.chzu.smart.home.domain.SuperEntity;
import lombok.Data;

/**
 * 权限
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class SysAuthority extends SuperEntity<SysAuthority> {

    private static final long serialVersionUID = 253675802315823990L;

    /**
     * 权限名
     */
    private String name;

    /**
     * 权限含义
     */
    private String value;
}
