package cn.edu.chzu.smart.home.swagger;


import cn.edu.chzu.smart.home.domain.GpsEntity;
import cn.edu.chzu.smart.home.domain.SysUser;
import cn.edu.chzu.smart.home.vo.SwaggerVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 获取当前吊坠位置并返回
 *
 * @author: hxy
 * @date: 2018/06/12
 */
@Data
@ApiModel(description = "吊坠位置gps数据获取")
public class GpsLocationSwagger extends SwaggerVO {

    /**
     * 具体信息
     */
    @ApiModelProperty(value = "响应数据", name = "data")
    private GpsEntity data;
}
