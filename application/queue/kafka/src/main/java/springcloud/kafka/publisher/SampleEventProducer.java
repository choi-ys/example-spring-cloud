package springcloud.kafka.publisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import springcloud.kafka.domain.SampleEvent;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 6:54
 */
@Slf4j
@Component
public class SampleEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public SampleEventProducer(KafkaTemplate kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void publish(String topicName, SampleEvent data) throws JsonProcessingException {
        kafkaTemplate.send(topicName, objectMapper.writeValueAsString(data));
        log.info("[PUBLISH][{}][{}]", topicName, data);
    }
}
