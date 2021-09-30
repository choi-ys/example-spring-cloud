package springcloud.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : choi-ys
 * @date : 2021-09-29 오후 5:26
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "springcloud.hello")
public class HelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}
