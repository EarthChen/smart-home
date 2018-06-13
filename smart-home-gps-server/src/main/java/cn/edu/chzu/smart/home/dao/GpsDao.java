package cn.edu.chzu.smart.home.dao;

import cn.edu.chzu.smart.home.SuperMapper;
import cn.edu.chzu.smart.home.domain.GpsEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * gps的dao
 *
 * @author wangqianlong
 * @create 2018-06-07 23:05
 */
@Repository
public interface GpsDao extends SuperMapper<GpsEntity> {

    /**
     * 通过id查找经纬度
     *
     * @param id
     * @return
     */
    GpsEntity queryById(long id);

    /**
     * 获取经纬度列表
     *
     * @param offet
     * @param limit
     * @return
     */
    List<GpsEntity> queryAll(@Param("offset") int offet, @Param("limit") int limit);

}
