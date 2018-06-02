package cn.edu.smart.home.enums;

import lombok.Getter;

/**
 * 结果枚举
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Getter
public enum ResultEnum {

    /**
     * 成功
     */
    SUCCESS(0, "成功"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
