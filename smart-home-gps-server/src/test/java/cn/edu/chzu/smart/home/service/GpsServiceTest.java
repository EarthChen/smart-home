package cn.edu.chzu.smart.home.service;


import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.domain.GpsEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class GpsServiceTest extends ApplicationTests {

  @Autowired
  private GpsService gpsService;

    @Test
    public void queryById() {
        long id=55;
       gpsService.queryById(id);
    }

    @Test
    public void queryAll() {
        List<GpsEntity> gpsEntityList = gpsService.queryAll();
        for (GpsEntity gpsEntity : gpsEntityList) {
            System.out.println(gpsEntity);
        }
    }
}
