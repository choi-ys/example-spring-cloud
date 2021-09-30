package springcloud.kakao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.feign.service.LocalSearchService;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 3:51
 */
@RestController
@RequestMapping("kakao")
public class KakaoLocalController {

    private final LocalSearchService localSearchService;

    public KakaoLocalController(LocalSearchService localSearchService) {
        this.localSearchService = localSearchService;
    }

    @GetMapping("local")
    public ResponseEntity local(@RequestParam(name = "query") String query) {
        return ResponseEntity.ok(localSearchService.findResponseAsLocationSearchResponseWrap(query));
    }
}
