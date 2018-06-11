package cn.edu.chzu.smart.home.fallbacks;


import cn.edu.chzu.smart.home.enums.ResultEnum;
import cn.edu.chzu.smart.home.vo.ResultVO;
import com.alibaba.fastjson.JSON;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 熔断器
 * <p>
 * 当服务不可用时友好返回
 *
 * @author: EarthChen
 * @date: 2018/06/02
 */
@Component
public class ServiceFallbackProvider implements ZuulFallbackProvider {

    @Override
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {

            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ResultVO resultVO = ResultVO.error(ResultEnum.SERVER_ERROR);
                String json = JSON.toJSONString(resultVO);
                return IOUtils.toInputStream(json);
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return headers;
            }
        };
    }

}
