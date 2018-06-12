package cn.edu.chzu.smart.home.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Swagger返回vo
 *
 * @author: EarthChen
 * @date: 2018/06/11
 */
@Data
public class SwaggerVO {

    /**
     * 状态吗
     */
    @ApiModelProperty(value = "响应码", name = "code", required = true)
    private Integer code;

    /**
     * 状态吗信息
     */
    @ApiModelProperty(value = "响应消息", name = "msg", required = true)
    private String msg;
}
