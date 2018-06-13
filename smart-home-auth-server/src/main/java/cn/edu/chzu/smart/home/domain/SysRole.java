package cn.edu.chzu.smart.home.domain;

import cn.edu.chzu.smart.home.domain.SysAuthority;
import com.baomidou.mybatisplus.annotations.TableField;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "角色Model")
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

    @TableField(exist = false)
    private Set<SysAuthority> authorities = new HashSet<>();
}
