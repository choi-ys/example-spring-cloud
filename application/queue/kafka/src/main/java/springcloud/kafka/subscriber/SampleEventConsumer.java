package springcloud.kafka.subscriber;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import springcloud.kafka.constants.topic.Topic;
import springcloud.kafka.domain.SampleEvent;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 6:55
 */
@Slf4j
@Component
public class SampleEventConsumer {

    private final ObjectMapper objectMapper;

    public SampleEventConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = Topic.SAMPLE_TOPIC_NAME)
    public void subscribe(ConsumerRecord<String, String> consumerRecord) throws Exception {
        long timestamp = consumerRecord.timestamp();
        String topic = consumerRecord.topic();
        String key = consumerRecord.key();
        long offset = consumerRecord.offset();
        int partition = consumerRecord.partition();
        SampleEvent sampleEvent = objectMapper.readValue(consumerRecord.value(), SampleEvent.class);
        log.info("[CONSUME][{}][topic:{}][key:{}, offset:{}, partition :{}][{}]", timestamp, topic, key, offset, partition, sampleEvent);
    }
}
