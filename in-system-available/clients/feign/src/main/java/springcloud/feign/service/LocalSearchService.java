package springcloud.feign.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import springcloud.feign.domain.response.kakao.local.LocalSearchResponseWrap;

@Service
public class LocalSearchService {
    private static final String authKey = "KakaoAK 464b4c25cadd87ca45f1ea99a7822608";
    private final KakaoLocalSearchClient kakaoLocalSearchClient;

    public LocalSearchService(KakaoLocalSearchClient kakaoLocalSearchClient) {
        this.kakaoLocalSearchClient = kakaoLocalSearchClient;
    }

    public ResponseEntity<String> findResponseResultAsString(String keyword) {
        return kakaoLocalSearchClient.findLocationWithHeader(authKey, keyword);
    }

    public ResponseEntity<LocalSearchResponseWrap> findResponseAsLocationSearchResponseWrap(String keyword) {
        return kakaoLocalSearchClient.findLocation(authKey, keyword);
    }
}
