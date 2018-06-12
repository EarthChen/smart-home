package cn.edu.chzu.smart.home.domain;

import cn.edu.chzu.smart.home.domain.SuperEntity;
import lombok.Data;
import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 * @author wangqianlong
 * @create 2018-06-05 10:04
 */
@Data
public class GpsEntity extends SuperEntity<GpsEntity> {
    private Long id;
    private String latitude;
    private String longitude;


    @Override
    public String toString() {
        return "GpsEntity{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", id=" + id +
                '}';
    }

}
