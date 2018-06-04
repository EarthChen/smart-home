package cn.edu.chzu.smart.home.config.properites;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 资源服务配置
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Component
@Data
@ConfigurationProperties(prefix = "server-security")
public class ServerSecurityProperties {

    private List<ClientProperties> clientPropertiesList = new ArrayList<>();

}
