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