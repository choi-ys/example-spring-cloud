package springcloud.kakao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 3:50
 */
@SpringBootApplication(scanBasePackages = "springcloud")
public class KakaoLocalApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaoLocalApplication.class);
    }
}
