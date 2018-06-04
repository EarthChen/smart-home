# smart-home


## 环境
* maven 3.x
* spring boot 1.5.13
* spring cloud Edgware.SR3

* mysql
* redis



## 服务

## smart-home-domain
领域类 供其他服务引入

## smart-home-dao
数据库访问层  供其他服务引入


## smart-home-common
公共 供其他服务引入

### smart-home-eureka-server
服务注册中心

端口：8761

## smart-home-zuul-gateway

zuul网关

端口：9000

## smart-home-auth-server
认证授权服务器

端口：8762

### 端点

1. /auth/user/register：用户注册

2. /auth/oauth/token ：登录获取token

3. /auth/user/current：获取当前用户信息

### 配置客户端认证信息

每次新加一个服务，需要在该应用的application.yml配置文件配置相应的客户端信息
```yaml
# 配置客户端
server-security:
  clientPropertiesList:
    - clientName: android
      clientSecret: android
      scopes: xx
      authorizedGrantTypes:
        - password
        - authorization_code
        - refresh_token
    - clientName: test
      clientSecret: test
      scopes: all
      authorizedGrantTypes:
        - password
        - authorization_code
        - refresh_token
```

并且在每个新添加的应用中配置获取信息的url，例在smart-home-kitchen-server模块的application.yml
```yaml
security:
  oauth2:
    resource:
      id: smart-home-kitchen-server
      user-info-uri: http://localhost:9000/auth/user/current
      prefer-token-info: false
```

## smart-home-kitchen-server

厨房服务

端口：8763




