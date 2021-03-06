package springcloud.rabbitmq.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import springcloud.rabbitmq.domain.SampleTask;

import static springcloud.rabbitmq.config.RabbitMQConfig.RABBIT_SAMPLE_EXCHANGE_NAME;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:17
 */
@Slf4j
@Component
public class SampleTaskConsumer {

    @RabbitListener(id = RABBIT_SAMPLE_EXCHANGE_NAME, queues = "rabbit.sample")
    public void subscribe(SampleTask sampleTask){
        log.info("[CONSUME][{}:{}][{}]", RABBIT_SAMPLE_EXCHANGE_NAME, "rabbit.sample", sampleTask);
    }
}
