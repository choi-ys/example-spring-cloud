package springcloud.rabbitmq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import springcloud.rabbitmq.domain.SampleTask;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:16
 */
@Slf4j
@Component
public class SampleTaskPublisher {

    private final RabbitTemplate rabbitTemplate;

    public SampleTaskPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(String exchangeName, String queueName, SampleTask sampleTask) {
        rabbitTemplate.convertAndSend(exchangeName, queueName, sampleTask);
        log.info("[PUBLISH][{}:{}][{}]", exchangeName, queueName, sampleTask);
    }
}
