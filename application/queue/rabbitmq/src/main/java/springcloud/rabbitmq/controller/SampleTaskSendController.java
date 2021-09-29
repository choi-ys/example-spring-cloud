package springcloud.rabbitmq.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.rabbitmq.config.RabbitMQConfig;
import springcloud.rabbitmq.config.SampleRabbitQueue;
import springcloud.rabbitmq.domain.SampleTask;
import springcloud.rabbitmq.publisher.SampleTaskPublisher;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 5:45
 */
@RestController
@RequestMapping("send")
public class SampleTaskSendController {
    private final SampleTaskPublisher sampleTaskPublisher;

    public SampleTaskSendController(SampleTaskPublisher sampleTaskPublisher) {
        this.sampleTaskPublisher = sampleTaskPublisher;
    }

    // http://localhost:5001/send/task?message=hello
    @GetMapping("task")
    public ResponseEntity sendData(@RequestParam(name = "message") String message) {
        sampleTaskPublisher.publish(
                RabbitMQConfig.RABBIT_SAMPLE_EXCHANGE_NAME,
                SampleRabbitQueue.SAMPLE_TASK.getQueueName(),
                new SampleTask(message)
        );
        return ResponseEntity.noContent().build();
    }
}
