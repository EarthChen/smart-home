package cn.edu.chzu.smart.home.enums;

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
    SUCCESS(0, "成功"),

    CURRENT_USER_ALREADY_EXIST(20001, "当前用户已存在"),

    SAVE_USER_ERROR(20002,"保存用户信息失败"),

    SERVER_ERROR(50001, "服务器暂时不可用清稍后重试"),;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
