# my-cloud
spring boot整合spring cloud eureka,config,zuul,hystrix,ribbon,feign等组件的一个项目

#eureka-server集群搭建
##1.引入依赖
`
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
`
##2.启动类加注解  @EnableEurekaServer 或 @EnableDiscoveryClient 二者区别为：
@EnableEurekaClient，适用于注册中心是eureka;注解是基于 spring-cloud-netflix 依赖

@EnableDiscoveryClient, 适用范围广例如：zookeeper注册中心，注解是基于 spring-cloud-commons 依赖
##3.集群配置详见项目
#eureka权限配置在Server端
`<dependency>
     　　<groupId>org.springframework.boot</groupId>
     　　<artifactId>spring-boot-starter-security</artifactId>
 </dependency>
`
#配置用户名密码
spring.security.user.name=admin
spring.security.user.password=admin
#自定义Security拦截规则 WebSecurityConfig.class

#作者：tajinshi
#qq:605091800