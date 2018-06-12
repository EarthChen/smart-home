package cn.edu.chzu.smart.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 床垫启动类
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MattressApplication {

    public static void main(String[] args) {
        SpringApplication.run(MattressApplication.class, args);
    }
}
