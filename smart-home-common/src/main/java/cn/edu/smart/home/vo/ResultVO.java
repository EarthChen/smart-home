package cn.edu.smart.home;

import lombok.Data;

import java.io.Serializable;

/**
 * 结果vo
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -5897234194040793245L;

    /**
     * 状态吗
     */
    private Integer code;

    /**
     * 状态吗信息
     */
    private String msg;

    /**
     * 具体信息
     */
    private T data;


    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}