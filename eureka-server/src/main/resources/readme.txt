eureka单点配置：
server:
  port: 8080
spring:
  application:
    name: eureka-server
eureka:
  client:
    service-url: http://localhost:8080/eureka
    #表明当前为服务端
    fetch-registry: false
    #当前为单机版，不可相互注册
    register-with-eureka: false