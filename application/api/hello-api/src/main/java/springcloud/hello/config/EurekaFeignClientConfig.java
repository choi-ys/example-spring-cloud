package springcloud.hello.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "springcloud.hello.service.eureka")
public class EurekaFeignClientConfig {
}
