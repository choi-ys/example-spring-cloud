package springcloud.hello.service.eureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 7:12
 */

/**
 * @FeignClient("kakao-api")
 *  - Eureka에 등록된 kakao-api project의
 *    application.yml에 설정된 spring.appplication.name 항목을 통해 host로 인식 가능
 */
@FeignClient("kakao-api")
public interface KakaoApiEurekaClientService {

    @GetMapping("/instance")
    String instance();
}
