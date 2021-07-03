对应的视频地址: https://www.bilibili.com/video/BV1yE411x7Ky

# Spring Cloud 组件

- 服务注册中心: ~~Eureka~~, Zookeeper, Consul, Nacos
- 服务调用: Ribbon, LoadBalancer
- 服务调用2: ~~Feign~~, OpenFeign
- 服务降级: ~~Hystrix~~, resilience4j（国外）, sentienl（国内）
- 服务网关: ~~Zuul~~, gateway
- 服务配置: ~~Config~~, Nacos
- 服务总线: ~~Bus~~, Nacos

# Provider-payment-8001

**Create database and user in MySQL**

```sql
create database springcloud_guigu default charset utf8 collate utf8_general_ci;
create user 'springcloud'@'%' identified by '123456';
grant all privileges on springcloud_guigu.* to "springcloud"; 
flush privileges;
```

**Create table**

```sql
CREATE TABLE `payment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serial` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支付流水号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付表' ROW_FORMAT = Dynamic;
```