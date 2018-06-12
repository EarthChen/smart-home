package cn.edu.chzu.smart.home.controller;

import cn.edu.chzu.smart.home.domain.GpsEntity;
import cn.edu.chzu.smart.home.service.GpsService;

import cn.edu.chzu.smart.home.swagger.GpsLocationSwagger;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  /* @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public Model detail(@PathVariable("id") long id, Model model) {
        GpsEntity gpsEntity = gpsService.queryById(id);
        model.addAttribute("gpsEntity", gpsEntity);
        return model;
    }*/

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "所有吊坠信息", httpMethod = "GET", response = GpsLocationSwagger.class)
    private Map<String, Object> getlist() {
        Map<String, Object> modelmap = new HashMap<String, Object>();
        List<GpsEntity> list = gpsService.queryAll();
        modelmap.put("gpsentity", list);
        return modelmap;
    }

    /*
    获取吊坠当前位置信息
    param：id
    return：吊坠位置经度纬度
     */
    @PostMapping("/getnowlocate")
    @ApiOperation(value = "吊坠位置信息", httpMethod = "POST", response = GpsLocationSwagger.class)
    public GpsEntity getlocationbyid(@RequestParam long id,Model model) {
        GpsEntity gpsEntity = gpsService.queryById(id);
        model.addAttribute("gpsEntity", gpsEntity);
        return gpsEntity;
    }


}
