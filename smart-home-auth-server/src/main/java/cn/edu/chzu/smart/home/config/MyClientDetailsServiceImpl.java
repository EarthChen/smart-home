package cn.edu.chzu.smart.home.config;

import cn.edu.chzu.smart.home.config.properites.ClientProperties;
import cn.edu.chzu.smart.home.config.properites.ServerSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 配置客户端信息
 *
 * @author: EarthChen
 * @date: 2018/06/04
 */
@Component
public class MyClientDetailsServiceImpl implements ClientDetailsService {

    @Autowired
    private ServerSecurityProperties serverSecurityProperties;

    private ClientDetailsService clientDetailsService;

    @PostConstruct
    public void init() {
        InMemoryClientDetailsServiceBuilder inMemoryClientDetailsServiceBuilder = new InMemoryClientDetailsServiceBuilder();

        List<ClientProperties> clientPropertiesLists = serverSecurityProperties.getClientPropertiesList();
        for (ClientProperties clientProperties : clientPropertiesLists) {
            // 当客户端秘钥为空
            if (!clientProperties.getClientSecret().isEmpty()) {
                inMemoryClientDetailsServiceBuilder
                        .withClient(clientProperties.getClientName())
                        .scopes(clientProperties.getScopes())
                        .secret(clientProperties.getClientSecret())
                        .authorizedGrantTypes(clientProperties.getAuthorizedGrantTypes())
                ;
            } else {
                inMemoryClientDetailsServiceBuilder
                        .withClient(clientProperties.getClientName())
                        .scopes(clientProperties.getScopes())
                        .authorizedGrantTypes(clientProperties.getAuthorizedGrantTypes())
                ;
            }

        }
        try {
            clientDetailsService = inMemoryClientDetailsServiceBuilder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientDetailsService.loadClientByClientId(clientId);
    }
}
