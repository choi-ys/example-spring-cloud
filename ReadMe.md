Project structure
===
```
├─application
│  ├─admin (micro service server monitoring by spring-boot-admin)
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