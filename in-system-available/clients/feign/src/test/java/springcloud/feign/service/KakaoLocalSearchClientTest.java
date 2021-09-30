package springcloud.feign.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class KakaoLocalSearchClientTest {

    @Autowired
    KakaoLocalSearchClient kakaoLocalSearchClient;

    @Test
    public void findLocation() {
        //given
        String query = "반포동";
        String authHeaderValue = "KakaoAK 464b4c25cadd87ca45f1ea99a7822608";
        //when
        ResponseEntity<String> response = kakaoLocalSearchClient.findLocationWithHeader(authHeaderValue, query);

        //then
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}
