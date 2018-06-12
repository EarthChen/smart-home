package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 床垫服务测试
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@Slf4j
public class MattressServiceImplTest extends ApplicationTests {

    @Autowired
    private MattressServiceImpl mattressService;

    @Test
    public void getMattressPage() {
        Pageable pageable = new PageRequest(1, 10);
        List<MattressData> mattressDataList = mattressService.getMattressPage(pageable);
        log.info(mattressDataList.toString(), mattressDataList.size());
    }

    @Test
    public void getMattressPageWithSn() {
        Pageable pageable = new PageRequest(1, 10);
        String sn = "Z55261";
        List<MattressData> mattressDataList = mattressService.getMattressPageWithSn(pageable, sn);
        log.info(mattressDataList.toString(), mattressDataList.size());
    }
}