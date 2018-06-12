package cn.edu.chzu.smart.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 卧室服务启动类
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class BedroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(BedroomApplication.class, args);
    }

}
