Project structure
===
```
├─application
│  ├─admin (monitoring for each micro service server by spring-boot-admin with actuator)
│  ├─api
│  │  ├─gateway (api gateway : discovery client(eureka, spring-boot-admin, sleuth & zipkin)
│  │  ├─hello-api (internal-service-api : discovery client(eureka, spring-boot-admin, sleuth & zipkin)
│  │  └─kakao-api (external-service-api : discovery client(eureka, spring-boot-admin, sleuth & zipkin)
│  ├─eureka (discovery server by eureka)
│  └─queue
│      ├─kafka-pub-sub
│      └─rabbitmq-pub-sub
├─in-system-available
│  └─clients
│      └─feign (external service client interface by feign)
└─independently
    └─jackson-converter (jackson dependency only util project)
```
