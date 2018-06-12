package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.constant.MattressConstant;
import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import cn.edu.chzu.smart.home.service.MattressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 创建控制器
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@RestController
public class MattressController {

    @Autowired
    private MattressService mattressService;


    /**
     * 分页获取床垫信息
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @GetMapping(MattressConstant.GET_MATTRESS_PAGE_URL)
    public List<MattressData> getMattressPage(@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        return mattressService.getMattressPage(pageable);
    }

    /**
     * 分页根据sn获取床垫信息
     *
     * @param pageIndex
     * @param pageSize
     * @param sn
     * @return
     */
    @GetMapping(MattressConstant.GET_MATTRESS_PAGE_WITH_SN_URL)
    public List<MattressData> getMattressPageWithSn(@RequestParam(value = "pageIndex", required = false, defaultValue = "0") int pageIndex,
                                                    @RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
                                                    @PathVariable("sn") String sn) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        return mattressService.getMattressPageWithSn(pageable, sn);
    }
}
