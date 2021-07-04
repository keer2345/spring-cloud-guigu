

# Provider-payment-8001

## Database

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

## Run

Run at parent *pom.xml* directory:

```shell
mvn spring-boot:run -pl provider-payment-8001
```

## Test

We can using *Postcode* plugin in VSCode, or use *curl*:

**Create Payment**

```shell
> curl -X POST -H "Content-Type: application/json" -d '{"serial":"java"}' http://127.0.0.1:8001/payment/create
{"code":200,"message":"insert successful","data":1}%   
```

Or:

```shell
> touch payment.json
> echo '{"serial": "kotlin"}' > payment.json
> curl -X POST -H "Content-Type: application/json"  -d @payment.json http://127.0.0.1:8001/payment/create
{"code":200,"message":"insert successful","data":1}%   
```

**Get Payment by ID**

```shell
> curl http://127.0.0.1:8001/payment/get/1
{"code":200,"message":"query successful","data":{"id":1,"serial":"java"}}
```

## Developer tools

1. Add dependency:

```xml

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

2. IDEA -> Build, Execution, Deployment -> Compiler
    - Automatically show first error in editor
    - Display notification on build completion
    - Build project automatically
    - Compile independent modules in parallel

3. Double `Shift` in IDEA, search `Registry...`, then check:
    - `compiler.automake.allow.when.app.running`
    - `actionSystem.assertFocusAccessFormEdt`

# Add Eureka Client

## Add dependency

```xml

<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

## Add Main

```java

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
```

## appllication.yml

```yml
spring:
   application:
      name: payment-service
      
eureka:
  client:
    #表示是否将自己注册进EurekaServer默认为true。
    register-with-eureka: true
    #是否从EurekaServer抓取已有的注册信息，默认为true。单节点无所谓，集群必须设置为true才能配合ribbon使用负载均衡
    fetchRegistry: true
    service-url:
      #单机版
      defaultZone: http://localhost:7001/eureka
      # 集群版
      # defaultZone: http://eureka7001.com:7001/eureka,http://eureka7002.com:7002/eureka
```