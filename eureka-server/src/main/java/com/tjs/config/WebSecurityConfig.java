//package com.tjs.eurekaserver.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * 如果加入Eureka权限的依赖需要配置如下代码
// * <dependency>
// *      　　<groupId>org.springframework.boot</groupId>
// *      　　<artifactId>spring-boot-starter-security</artifactId>
// *  </dependency>
// */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        //禁用csrf让eureka客户端注册
////        http.csrf().disable();
//        //或者设置/eureka/**可以被访问
//        http.csrf().ignoringAntMatchers("/eureka/**");
//    }
//}
