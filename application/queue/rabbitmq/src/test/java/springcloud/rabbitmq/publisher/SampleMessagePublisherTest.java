package springcloud.rabbitmq.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springcloud.rabbitmq.config.SampleRabbitQueue;
import springcloud.rabbitmq.domain.SampleMessageTask;

import static springcloud.rabbitmq.config.RabbitMQConfig.RABBIT_SAMPLE_EXCHANGE_NAME;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:22
 */
@SpringBootTest
class SampleMessagePublisherTest {

    @Autowired
    private SampleMessagePublisher sampleMessagePublisher;

    @Test
    void sampleMessagePublishTest() {
        String message = "hello rabbitMQ";
        sampleMessagePublisher.publish(
                RABBIT_SAMPLE_EXCHANGE_NAME,
                SampleRabbitQueue.SAMPLE_TASK.getQueueName(),
                new SampleMessageTask(message)
        );
    }
}