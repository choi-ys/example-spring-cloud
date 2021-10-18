package springcloud.config.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author : choi-ys
 * @date : 2021/10/17 12:43 오후
 */
@SpringBootApplication
@EnableConfigServer
public class InternalConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternalConfigServerApplication.class);
    }
}
