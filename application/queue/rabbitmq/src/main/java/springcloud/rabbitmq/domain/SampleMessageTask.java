package springcloud.rabbitmq.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 4:25
 */
@Getter
@NoArgsConstructor
@ToString(exclude = "DEFAULT_MESSAGE")
public class SampleMessageTask {

    private String id;
    private String message;

    @JsonIgnore
    private String DEFAULT_MESSAGE = "not exist message, do something";

    public SampleMessageTask(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = StringUtils.hasText(message) ? message : DEFAULT_MESSAGE;
    }
}
