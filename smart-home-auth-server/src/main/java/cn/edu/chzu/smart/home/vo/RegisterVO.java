package cn.edu.chzu.smart.home.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


/**
 * 注册结果
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Data
public class RegisterVO {


    private Long id;

    private String username;

    @JsonIgnore
    private String password;

    private String email;
}
