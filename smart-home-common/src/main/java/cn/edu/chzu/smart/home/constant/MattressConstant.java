package cn.edu.chzu.smart.home.constant;

/**
 * 床垫常量
 *
 * @author: EarthChen
 * @date: 2018/06/12
 */
public class MattressConstant {

    /**
     * 床垫服务名
     */
    public static final String MATTRESS_SERVICE_NAME = "smart-home-mattress-sensor-service";

    /**
     * 分页获取床垫信息列表
     */
    public static final String GET_MATTRESS_PAGE_URL = "/mattress/list";

    /**
     * 根据序列号sn分页获取床垫信息列表
     */
    public static final String GET_MATTRESS_PAGE_WITH_SN_URL = "/mattress/list/{sn}";


}
