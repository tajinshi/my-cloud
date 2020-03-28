http://192.168.1.4:8090/actuator/health
#springboot 2.2.2 整合actutor 404bug解决
management.endpoints.web.exposure.include=refresh
eureka.instance.status-page-url-path=/actuator/info
eureka.instance.health-check-url-path=/actuator/health
eureka.instance.home-page-url-path=/
management.endpoints.web.exposure.include=*

1. spring cloud整合Eureka,config,actuator
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-config</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>