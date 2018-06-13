package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.GpsEntity;
import cn.edu.chzu.smart.home.service.GpsService;

import cn.edu.chzu.smart.home.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


/**
 * @author wangqianlong
 * @create 2018-06-08 12:45
 */
@RestController
@Api(value = "Gps", tags = {"Gps"}, description = "Gps吊坠相关")
public class GpsController {

    @Autowired
    private GpsService gpsService;


    @GetMapping(value = "/all")
    @ApiOperation(value = "所有吊坠信息", httpMethod = "GET")
    private ResultVO<List<GpsEntity>> getList() {
        return ResultVO.success(gpsService.queryAll());
    }

    /**
     * 获取吊坠当前位置信息
     *
     * @param id
     * @return
     */
    @GetMapping("/nowlocate/{id}")
    @ApiOperation(value = "吊坠位置信息", httpMethod = "GET")
    public ResultVO<GpsEntity> getLocationById(@PathVariable("id") long id) {
        GpsEntity gpsEntity = gpsService.queryById(id);
        return ResultVO.success(gpsEntity);
    }


}
