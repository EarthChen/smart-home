package cn.edu.chzu.smart.home.service;

import cn.edu.chzu.smart.home.constant.MattressConstant;
import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 从床垫服务获取数据
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@FeignClient(MattressConstant.MATTRESS_SERVICE_NAME)
public interface MattressServiceClient {

    /**
     * 分页获取床垫列表
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(MattressConstant.GET_MATTRESS_PAGE_URL)
    List<MattressData> getMattressPage(@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize);


    /**
     * 根据sn分页获取床垫列表
     *
     * @param pageIndex
     * @param pageSize
     * @param sn
     * @return
     */
    @GetMapping(MattressConstant.GET_MATTRESS_PAGE_WITH_SN_URL)
    List<MattressData> getMattressPageWithSn(@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                                             @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                             @PathVariable("sn") String sn);
}
