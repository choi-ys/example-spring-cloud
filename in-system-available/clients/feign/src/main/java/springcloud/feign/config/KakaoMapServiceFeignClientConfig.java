package springcloud.feign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 8:57
 */
@Configuration
@EnableFeignClients(basePackages = "springcloud.feign.service")
public class KakaoMapServiceFeignClientConfig {
}
