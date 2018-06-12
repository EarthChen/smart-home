# smart-home


## 环境
* maven 3.x
* spring boot 1.5.13
* spring cloud Edgware.SR3

* mysql
* redis



# 服务

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

## smart-home-swagger

swagger支持，在需要swagger的模块中引入即可

swagger相关内容自行学习

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

# 说明

##  使用redis缓存模块

1.  在项目的pom.xml中引入依赖
```xml
<dependency>
            <groupId>cn.edu.chzu</groupId>
            <artifactId>smart-home-redis</artifactId>
            <version>${project.version}</version>
        </dependency>
```
2. 在项目的application.yml中配置redis的地址，然后就可以在项目中使用了
3. 在redis模块的**cn.edu.chzu.smart.home.key**包下按照模块创建自定义键名的类
4. 在项目的合适地方注入**RedisService**即可

## 认证服务器配置

### 测试认证授权
参照
https://gitee.com/fnet/Spring-CloudJiYuZuulDeTongYiShouQuanRenZheng

### 认证服务端配置(auth-server)
每次创建一个服务(应用)，需要在auth-server中的application.yml中进行如下配置:

```yaml
server-security:
  clientPropertiesList:
    - clientName: android
      clientSecret: android
      scopes: xx
      authorizedGrantTypes:
        - password
        - authorization_code
        - refresh_token
    - clientName: webapp
      scopes: all
      authorizedGrantTypes:
        - implicit
    - clientName: browser
      scopes: all
      authorizedGrantTypes:
        - refresh_token
        - password
```

> 各个属性含义：
>- **clientName**:服务名(客户端名，可以随便填写)
>- **clientSecret**：对应的密码，可以不含有这一项(以上两项配置决定在登录获取token时，使用basic auth认证方式，填写的username和password)
>- **scopes**:可以自定义任意字符串，在oauth协议中为权限之意
>- **authorizedGrantTypes**:认证方式,一共有以下几种：
    * 简化模式（implicit），(在redirect_uri 的Hash传递token; Auth客户端运行在浏览器中,如JS,Flash)
    * 密码模式（password），将用户名,密码传过去,直接获取token；
    * 客户端模式（client credentials），无用户,用户向客户端注册,然后客户端以自己的名义向'服务端'获取资源；
    * 授权码模式（authorization_code）通过客户端的后台服务器，与"服务提供商"的认证服务器进行互动。
    * **refresh_token**比较特别，在需要刷新令牌的客户端中添加该选项即可

### 资源服务端配置(kitchen-server为例)

每次创建一个服务(应用)，需要在kitchen-server中的application.yml中进行如下配置:

```xml
management.security.enabled: false

feign:
  hystirx:
    enable: true
    
security:
  oauth2:
    resource:
      id: smart-home-kitchen-server
      user-info-uri: http://localhost:9000/auth/user/current
      prefer-token-info: false
```

> 注意:
>- id为资源服务自定义名,一般为注册中心的服务名即可
>- user-info-uri：为获取认证权限的url，目前为http://localhost:9000/auth/user/current
>- prefer-token-info：暂时无需考虑，直接复制上述配置即可

还需要在该工程的cn.edu.chzu.smart.home.config包下创建一个配置类，

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;

/**
 * 资源配置
 *
 * @author: EarthChen
 * @date: 2018/06/03
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}
```

>里面的配置请见spring security相关知识

### 网关配置(smart-home-zuul-gateway)

创建一个新服务，需要在application.yml中配置反向代理的路由，参考如下配置，添加即可

```yaml
zuul:
  routes:
    auth-server:
      path: /auth/**
      sensitiveHeaders:
      serviceId: auth-server
    kitchen-server:
      path: /kitchen/**
      sensitiveHeaders:
      serviceId: smart-home-kitchen-server
  add-proxy-headers: true
```
>serviceId必须与注册中心中注册的服务名一致

## 在服务器运行

> 服务器默认只打开几个特殊端口，其他端口都需要自行打开，使用iptables命令

比如打开8761端口命令
```bash
$ sudo iptables -I INPUT -p tcp --dport 8761 -j ACCEPT
$ sudo iptables-save
```
>以上为临时打开端口，当服务器重启需要重新打开该端口，持久化规则，请自行查阅

### 三台服务器的信息

* ip: 192.168.85.208-210
* 用户名: smarthome
* 密码: smarthome

>轻易不要使用root权限，在普通用户下使用sudo命令，如果sudo不能用，自行百度添加sudo用户

### redis信息

192.168.85.208:6379

>测试阶段暂时不设置密码，生产环境请配置合理的密码

### mysql信息

ip: 192.168.85.208:3306
用户名: root
密码: 123456

>测试阶段暂时设置简单密码，生产环境请配置合理的密码和用户权限，访问白名单

### 直接在服务器运行方法

#### 本地打包，服务器运行

1. 在项目根目录下使用mvn clean package命令打包

如果需要跳过单元测试，请使用如下命令
```bash
$ mvn clean package -Dmaven.test.skip=true
```

2. 将打包好的xxx.jar传到服务器上(使用scp ftp等)

3. 在服务器上合适的地方运行该jar
```bash
$ java -jar xxxxx.jar
```
>如果需要携带参数或者将application.yml外置请自行搜索相关内容

#### 服务器打包运行
1. 进入服务器上的/home/smarthome/smart-home目录

2. 切换合适的分支(最新的代码)

3. 更新依赖包(如果当前代码未更新过依赖，将不需要)
```bash
$ mvn clean install -e -U
```
>maven相关知识请自行学习

4. 运行打包命令
```bash
$ mvn clean package -Dmaven.test.skip=true
```

5. 在服务器上合适的地方运行该jar
```bash
$ java -jar xxxxx.jar
```
>如果需要携带参数或者将application.yml外置请自行搜索相关内容

### docker运行

>- 首先请自行学习docker基础知识
>- 对于每个也运行的服务，都需要写自己的Dockerfile(可以参照已经有的)

#### 打包镜像
打包镜像时，请注意需要进入dockerfile所在的目录，运行如下命令:
```bash
$ sudo docker build -t <你的镜像名>:<tag> .
```

####　运行容器
当你打包好了镜像，可以在任意目录使用docker run命令运行该镜像
```bash
$ sudo docker run -p <宿主机端口>:<容器内端口> --name=<容器名> -d <你的镜像名>:<tag>
```
>相关命令的含义，自行学习docker

