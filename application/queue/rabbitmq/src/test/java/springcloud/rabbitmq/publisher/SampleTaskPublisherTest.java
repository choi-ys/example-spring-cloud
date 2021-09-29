package springcloud.rabbitmq.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springcloud.rabbitmq.config.SampleRabbitQueue;
import springcloud.rabbitmq.domain.SampleTask;

import static springcloud.rabbitmq.config.RabbitMQConfig.RABBIT_SAMPLE_EXCHANGE_NAME;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:22
 */
@SpringBootTest
class SampleTaskPublisherTest {

    @Autowired
    private SampleTaskPublisher sampleTaskPublisher;

    @Test
    void sampleMessagePublishTest() {
        String message = "hello rabbitMQ";
        sampleTaskPublisher.publish(
                RABBIT_SAMPLE_EXCHANGE_NAME,
                SampleRabbitQueue.SAMPLE_TASK.getQueueName(),
                new SampleTask(message)
        );
    }
}