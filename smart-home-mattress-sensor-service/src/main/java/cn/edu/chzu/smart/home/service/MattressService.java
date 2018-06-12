package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 床垫服务
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
public interface MattressService {

    /**
     * 分页获取所有床垫列表
     *
     * @param pageable
     * @return
     */
    List<MattressData> getMattressPage(Pageable pageable);

    /**
     * 分页获取序列号为sn的床垫列表
     *
     * @param pageable
     * @param sn
     * @return
     */
    List<MattressData> getMattressPageWithSn(Pageable pageable, String sn);

}
