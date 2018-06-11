package cn.edu.chzu.smart.home.vo.swagger;

import cn.edu.chzu.smart.home.domain.SysUser;
import cn.edu.chzu.smart.home.vo.SwaggerVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * user返回值
 *
 * @author: EarthChen
 * @date: 2018/06/11
 */
@Data
@ApiModel(description = "用户响应")
public class SysUserSwaggerVO extends SwaggerVO {

    /**
     * 具体信息
     */
    @ApiModelProperty(value = "响应数据", name = "data")
    private SysUser data;
}
