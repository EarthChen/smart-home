package cn.edu.chzu.smart.home.domain.auth;

import cn.edu.chzu.smart.home.domain.SuperEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Set;

/**
 * 用户
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class SysUser extends SuperEntity<SysUser> {

    private static final long serialVersionUID = -2640006241935295774L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     * <p>
     * 不显示给前端
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String imageUrl;


    /**
     * 角色 数据库表不存在
     */
    @TableField(exist = false)
    private Set<SysRole> roles;



}
