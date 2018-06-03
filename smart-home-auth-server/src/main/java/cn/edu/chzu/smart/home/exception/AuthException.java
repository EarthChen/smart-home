package cn.edu.chzu.smart.home.exception;

import cn.edu.chzu.smart.home.enums.ResultEnum;
import lombok.Getter;

/**
 * 自定义认证异常
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Getter
public class AuthException extends RuntimeException {

    private static final long serialVersionUID = 5342609240774296994L;

    private Integer code;

    public AuthException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public AuthException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
