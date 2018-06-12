package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.bedroom.MattressData;
import cn.edu.chzu.smart.home.service.MattressServiceClient;
import cn.edu.chzu.smart.home.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 床垫控制器
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
@RestController
public class MattressController {

    @Autowired
    private MattressServiceClient mattressServiceClient;

    /**
     * @return
     */
    @GetMapping("/mattress/list")
    public ResultVO getMattressList() {
        List<MattressData> mattressDataList = mattressServiceClient.getMattressPage(1, 10);
        return ResultVO.success(mattressDataList);
    }

    /**
     * @return
     */
    @GetMapping("/mattress/list/{sn}")
    public ResultVO getMattressListWithPage() {
        List<MattressData> mattressDataList = mattressServiceClient.getMattressPageWithSn(1, 10, "Z55261");
        return ResultVO.success(mattressDataList);
    }
}
