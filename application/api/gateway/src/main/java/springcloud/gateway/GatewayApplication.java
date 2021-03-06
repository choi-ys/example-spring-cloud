package springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 4:37
 */
//@EnableEurekaClient // eureka client only
@EnableDiscoveryClient // spring cloud common
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class);
    }
}
