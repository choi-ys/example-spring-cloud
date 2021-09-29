package springcloud.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.rabbitmq.config.RabbitMQConfig;
import springcloud.rabbitmq.config.SampleRabbitQueue;
import springcloud.rabbitmq.domain.SampleMessageTask;
import springcloud.rabbitmq.publisher.SampleMessagePublisher;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:45
 */
@RestController
@RequestMapping("send")
public class SampleMessageSendController {
    private final SampleMessagePublisher sampleMessagePublisher;

    public SampleMessageSendController(SampleMessagePublisher sampleMessagePublisher) {
        this.sampleMessagePublisher = sampleMessagePublisher;
    }

    // http://localhost:5001/send/sample?message=hello
    @GetMapping("sample")
    public ResponseEntity sendData(@RequestParam(name = "message") String message) {
        sampleMessagePublisher.publish(
                RabbitMQConfig.RABBIT_SAMPLE_EXCHANGE_NAME,
                SampleRabbitQueue.SAMPLE_TASK.getQueueName(),
                new SampleMessageTask(message)
        );
        return ResponseEntity.noContent().build();
    }
}
