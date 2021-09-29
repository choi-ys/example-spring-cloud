package springcloud.rabbitmq.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import springcloud.rabbitmq.domain.SampleMessageTask;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:16
 */
@Slf4j
@Component
public class SampleMessagePublisher {

    private final RabbitTemplate rabbitTemplate;

    public SampleMessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publish(String exchangeName, String queueName, SampleMessageTask sampleMessageTask) {
        rabbitTemplate.convertAndSend(exchangeName, queueName, sampleMessageTask);
        log.info("[PUBLISH][{}:{}][{}]", exchangeName, queueName, sampleMessageTask);
    }
}
