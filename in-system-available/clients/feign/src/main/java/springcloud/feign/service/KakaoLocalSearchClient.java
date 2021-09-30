package springcloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import springcloud.feign.domain.response.kakao.local.LocalSearchResponse;
import springcloud.feign.domain.response.kakao.local.LocalSearchResponseWrap;

/**
 * @See https://developers.kakao.com/docs/latest/ko/local/dev-guide
 */
@FeignClient(value = "kakao", url = "http://dapi.kakao.com")
public interface KakaoLocalSearchClient {

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<String> findLocationWithHeader(@RequestHeader("Authorization") String authHeader,
                                                  @RequestParam("query") String query);

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<LocalSearchResponseWrap> findLocation(@RequestHeader("Authorization") String authHeader,
                                                         @RequestParam("query") String query);

    @GetMapping("/v2/local/search/keyword.json")
    ResponseEntity<LocalSearchResponse> findResponse(@RequestHeader("Authorization") String authHeader,
                                                     @RequestParam("query") String query);
}
