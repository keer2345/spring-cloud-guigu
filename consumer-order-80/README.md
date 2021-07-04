# Consumer-order-80

## Run

Run the two maven projdet on different Terminal windows:

```shell
mvn spring-boot:run -pl provider-payment-8001
```

```shell
mvn spring-boot:run -pl consumer-order-80
```

**Or, we recommend to use _Run Dashboard (Services)_ on IDEA IntelliJ.**

## Test

```shell
> curl -X POST -H "Content-Type: application/json" -d '{"serial":"ruby"}' http://127.0.0.1:8000/consumer/payment/create
{"code":200,"message":"insert successful","data":1}%

> curl http://127.0.0.1:8000/consumer/payment/get/15
{"code":200,"message":"query successful","data":{"id":15,"serial":"ruby"}}% 
```

