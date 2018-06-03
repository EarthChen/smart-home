package cn.edu.chzu.smart.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * 厨房服务
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class KitchenServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KitchenServerApplication.class, args);
    }
}
