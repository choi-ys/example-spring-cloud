package springcloud.feign.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import springcloud.feign.domain.response.kakao.local.LocalSearchResponse;
import springcloud.feign.domain.response.kakao.local.LocalSearchResponseWrap;

import java.util.List;

@SpringBootTest
public class LocalSearchServiceTest {

    @Autowired
    LocalSearchService localSearchService;

    @Test
    public void findResponseAsLocationSearchResponseWrapTest() {
        // Given
        String keyword = "반포동";

        // When
        ResponseEntity<LocalSearchResponseWrap> locationReturnMapResponse = localSearchService.findResponseAsLocationSearchResponseWrap(keyword);
        LocalSearchResponseWrap localSearchResponseWrap = locationReturnMapResponse.getBody();
        List<LocalSearchResponse> localSearchResponse = localSearchResponseWrap.getLocalSearchResponse();

        // Then
        Assertions.assertTrue(localSearchResponse.size() > 0);
    }
}
