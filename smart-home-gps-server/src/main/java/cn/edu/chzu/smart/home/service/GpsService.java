package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.domain.GpsEntity;

import java.util.List;

/**
 * @author wangqianlong
 * @create 2018-06-08 12:39
 */

public interface GpsService {
    /*通过id查找经纬度*/
    GpsEntity queryById(long id);

    /*获取经纬度列表*/
    List<GpsEntity> queryAll();

}
