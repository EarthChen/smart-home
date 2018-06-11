package cn.edu.chzu.smart.home.vo.swagger;

import cn.edu.chzu.smart.home.vo.RegisterVO;
import cn.edu.chzu.smart.home.vo.SwaggerVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 注册响应
 *
 * @author: EarthChen
 * @date: 2018/06/11
 */
@Data
@ApiModel(description = "注册响应")
public class RegisterSwaggerVO extends SwaggerVO {

    /**
     * 具体信息
     */
    @ApiModelProperty(value = "响应数据", name = "data")
    private RegisterVO data;

}
