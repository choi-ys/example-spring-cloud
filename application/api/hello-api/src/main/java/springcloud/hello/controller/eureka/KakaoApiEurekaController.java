package springcloud.hello.controller.eureka;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.hello.service.eureka.KakaoApiEurekaClientService;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 7:01
 */
@RestController
@RequestMapping("kakao")
public class KakaoApiEurekaController {

    private final KakaoApiEurekaClientService kakaoApiEurekaClientService;

    public KakaoApiEurekaController(KakaoApiEurekaClientService kakaoApiEurekaClientService) {
        this.kakaoApiEurekaClientService = kakaoApiEurekaClientService;
    }

    // http://localhost:9001/kakao/instance
    @GetMapping("instance")
    public ResponseEntity findKakaoApiServerInstance() {
        return ResponseEntity.ok(kakaoApiEurekaClientService.instance());
    }
}
