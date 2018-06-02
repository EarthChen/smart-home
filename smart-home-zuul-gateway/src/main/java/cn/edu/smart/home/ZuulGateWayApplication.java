package cn.edu.smart.home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul网关
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulGateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulGateWayApplication.class, args);
    }

}
