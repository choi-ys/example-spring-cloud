package springcloud.kafka.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 6:49
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class SampleEvent {

    private String id;
    private String message;

    public SampleEvent(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
    }
}
