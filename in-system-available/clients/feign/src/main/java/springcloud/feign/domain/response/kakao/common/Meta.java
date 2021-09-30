package springcloud.feign.domain.response.kakao.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오후 3:27
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Meta {
    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("pageable_count")
    private int pageableCount;

    @JsonProperty("is_end")
    private boolean isEnd;
}
