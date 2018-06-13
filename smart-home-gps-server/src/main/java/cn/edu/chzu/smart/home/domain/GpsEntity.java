package cn.edu.chzu.smart.home.domain;

import lombok.Data;

/**
 * gps实体
 *
 * @author wangqianlong
 * @create 2018-06-05 10:04
 */
@Data
public class GpsEntity extends SuperEntity<GpsEntity> {

    private static final long serialVersionUID = -64113268962171441L;

    private String latitude;

    private String longitude;

}
