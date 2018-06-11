package cn.edu.chzu.smart.home.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 实体父类
 *
 * @author: EarthChen
 * @date: 2018/03/31
 */
@Getter
@Setter
public class SuperEntity<T extends Model> extends Model<T> {

    private static final long serialVersionUID = -4263419124367119871L;

    /**
     * 主键ID , 这里故意演示注解可以无
     */
    @ApiModelProperty(value = "id", name = "id", required = true, example = "1234654564654")
    private Long id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}