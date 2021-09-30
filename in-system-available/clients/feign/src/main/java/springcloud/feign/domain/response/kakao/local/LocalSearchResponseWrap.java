package springcloud.feign.domain.response.kakao.local;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springcloud.feign.domain.response.kakao.common.Meta;

import java.util.List;

@Getter
@NoArgsConstructor
public class LocalSearchResponseWrap {

    @JsonProperty("meta")
    private Meta meta;

    @JsonProperty("documents")
    private List<LocalSearchResponse> localSearchResponse;
}
