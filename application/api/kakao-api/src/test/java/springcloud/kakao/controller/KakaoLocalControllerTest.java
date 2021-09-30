package springcloud.kakao.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import springcloud.kakao.config.test.EnableMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 4:00
 */
@SpringBootTest
@EnableMockMvc
class KakaoLocalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String KAKAO_LOCAL_URL = "/kakao/local";

    @Test
    void kakaoLocalApiTest() throws Exception {
        // Given
        String query = "반포동";
        String urlTemplate = KAKAO_LOCAL_URL.concat("?query=").concat(query);

        // When
        ResultActions resultActions = this.mockMvc.perform(get(urlTemplate)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        );

        // Then
        resultActions.andDo(print())
                .andExpect(status().isOk())
        ;
    }
}