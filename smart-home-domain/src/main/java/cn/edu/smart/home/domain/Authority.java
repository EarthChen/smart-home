package cn.edu.smart.home.domain;

import lombok.Data;

/**
 * 权限
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class Authority extends SuperEntity<Authority> {
    private static final long serialVersionUID = 253675802315823990L;

    private String name;
    private String value;
}
