package springcloud.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springcloud.kafka.constants.topic.Topic;
import springcloud.kafka.domain.SampleEvent;
import springcloud.kafka.publisher.SampleEventProducer;

/**
 * @author : choi-ys
 * @date : 2021-09-30 오전 7:14
 */
@RestController
@RequestMapping("send")
public class SampleEventSendController {
    private final SampleEventProducer sampleEventProducer;

    public SampleEventSendController(SampleEventProducer sampleEventProducer) {
        this.sampleEventProducer = sampleEventProducer;
    }

    // http://localhost:5002/send/event?message=hello
    @GetMapping("event")
    public ResponseEntity sendEvent(@RequestParam(name = "message") String message) throws JsonProcessingException {
        sampleEventProducer.publish(Topic.SAMPLE_TOPIC_NAME, new SampleEvent(message));
        return ResponseEntity.ok().body(message);
    }

}
