package cn.edu.chzu.smart.home.domain.bedroom;

import cn.edu.chzu.smart.home.domain.SuperEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 床垫数据
 *
 * @author: EarthChen
 * @date: 2018/04/24
 */
@Data
@TableName("mattress")
public class MattressData extends SuperEntity<MattressData> {

    private static final long serialVersionUID = 7781439958893865189L;

    /**
     * 设备唯一序列号
     */
    private String sn;

    /**
     * 固件版本
     */
    private Integer fv;

    /**
     * 体征状态枚举
     * <p>
     * on=在床,off=离床,mov=体动,call=呼叫
     */
    private String state;

    /**
     * 心跳频率
     */
    private Integer heartbeat;

    /**
     * 呼吸频率
     */
    private Integer breath;

    /**
     * 尿湿：true 0xc3为尿湿false0xc2 为非尿湿
     */
    private boolean wet;

    /**
     * 呼吸暂停次数24小时清零，3秒一次发送， 累加
     */
    private Integer odor;

    /**
     * 在床 离床的 辅助判断
     */
    private Integer weight;


    /**
     * 身体位置，例如[6,9]
     */
    private Integer[] position;

    /**
     * 时间
     */
    @TableField("createTime")
    private Date createTime;


}
