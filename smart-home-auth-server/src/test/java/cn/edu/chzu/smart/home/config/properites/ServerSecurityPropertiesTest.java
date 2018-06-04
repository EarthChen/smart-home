package cn.edu.chzu.smart.home.config.properites;

import cn.edu.chzu.smart.home.ApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Slf4j
public class ServerSecurityPropertiesTest extends ApplicationTests {

    @Autowired
    private ServerSecurityProperties serverSecurityProperties;


    @Test
    public void testGet() {
        String str = serverSecurityProperties.toString();
        log.info(str);


    }

}