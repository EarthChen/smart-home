package cn.edu.chzu.smart.home.service.impl;

import cn.edu.chzu.smart.home.dao.GpsDao;
import cn.edu.chzu.smart.home.domain.GpsEntity;
import cn.edu.chzu.smart.home.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-06-08 12:40
 */
@Service
public class GpsServiceimpl implements GpsService {
    @Autowired
    private GpsDao gpsDao;

    @Override
    public GpsEntity queryById(long id) {

        return gpsDao.queryById(id);
    }

    @Override
    public List<GpsEntity> queryAll() {
        return gpsDao.queryAll(60, 64);
    }
}
