package cn.edu.chzu.smart.home.config.properites;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户端配置
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Data
public class ClientProperties {

    /**
     * 客户端名
     */
    private String clientName;

    /**
     * 密码
     */
    private String clientSecret = "";

    /**
     * 权限
     */
    private String scopes;

    /**
     * 认证类型
     */
    private String[] authorizedGrantTypes = new String[5];


}
