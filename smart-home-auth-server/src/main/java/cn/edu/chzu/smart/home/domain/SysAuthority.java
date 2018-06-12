package cn.edu.chzu.smart.home.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 权限
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
@ApiModel(description = "权限Model")
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
