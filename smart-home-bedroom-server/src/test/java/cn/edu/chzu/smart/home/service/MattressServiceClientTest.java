package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: EarthChen
 * @date: 2018/06/12
 */
@Slf4j
public class MattressServiceClientTest extends ApplicationTests {

    @Autowired
    private MattressServiceClient mattressServiceClient;

    @Test
    public void getMattressPage() {
        List<MattressData> mattressDataList = mattressServiceClient.getMattressPage(1, 10);
        log.info("分页获取床垫数据{}", mattressDataList.toString());
    }

    @Test
    public void getMattressPageWithSn() {
        List<MattressData> mattressDataList = mattressServiceClient.getMattressPageWithSn(1, 10, "Z55261");
        log.info("根据sn分页查询{}", mattressDataList.toString());
    }
}