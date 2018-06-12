package cn.edu.chzu.smart.home.dao;


import cn.edu.chzu.smart.home.ApplicationTests;
import cn.edu.chzu.smart.home.dao.GpsDao;
import cn.edu.chzu.smart.home.domain.GpsEntity;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class GpsDaoTest extends ApplicationTests {
    @Autowired
    private GpsDao gpsDao;

    @Test
    public void queryById() {
        long id = 60;
        GpsEntity gpsEntity = gpsDao.queryById(id);
        System.out.println(gpsEntity);

    }

    @Test
    public void queryAll() {
        List<GpsEntity> gpsEntityList = gpsDao.queryAll(60,70);
        for (GpsEntity gpsEntity : gpsEntityList) {
            System.out.println(gpsEntity);
        }
    }

}
