package cn.edu.chzu.smart.home.handler;

import cn.edu.chzu.smart.home.exception.AuthException;
import cn.edu.chzu.smart.home.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 全局异常处理器
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    public ResultVO handlerSellerException(AuthException e) {
        return ResultVO.error(e.getCode(), e.getMessage());
    }


    @ExceptionHandler(value = BindException.class)
    @ResponseBody
    public ResultVO handlerBindException(BindException e) {

        log.info("[参数校验]---绑定异常");

        List<ObjectError> errors = e.getAllErrors();
        ObjectError error = errors.get(0);
        String msg = error.getDefaultMessage();
        return ResultVO.error(100, String.format("参数校验异常：%s", msg));
    }
}
