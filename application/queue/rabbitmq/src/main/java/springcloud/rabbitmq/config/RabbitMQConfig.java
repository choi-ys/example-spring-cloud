package springcloud.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcloud.converter.jackson.JacksonConverter;
import springcloud.rabbitmq.domain.SampleTask;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableRabbit
public class RabbitMQConfig {
    @Resource
    private RabbitProperties rabbitProperties;

    public static final String RABBIT_SAMPLE_EXCHANGE_NAME = "rabbitmq-sample-topic"; // kafka의 topic?

    /**
     * RabbitMQ를 통해 통신되는 데이터 형식 지정(Java POJO)
     */
    @Bean
    public DefaultClassMapper classMapper() {
        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("sampleMessageTask", SampleTask.class);
        classMapper.setIdClassMapping(idClassMapping);
        return classMapper;
    }

    /**
     * RabbitMQ의 message json 직렬화 설정
     */
    @Bean
    public MessageConverter rabbitMessageConverter() {
        Jackson2JsonMessageConverter jsonConverter = new Jackson2JsonMessageConverter(JacksonConverter.getInstance());
        jsonConverter.setClassMapper(classMapper());
        return jsonConverter;
    }

    /**
     * RabbitMQ 연동 정보
     */
    @Bean
    public ConnectionFactory rabbitConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        log.info("userName:: {}", rabbitProperties.getUsername());
        connectionFactory.setUsername(rabbitProperties.getUsername());
        connectionFactory.setPassword(rabbitProperties.getPassword());
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CHANNEL);

        return connectionFactory;
    }

    /**
     * Admin 설정 관련 부분
     * RabbitMQ에 admin 권한이 있는 계정으로 접속한 후에
     * exchange와 queue를 등록하고 매핑해준다.
     *
     * @param rabbitConnectionFactory
     * @return
     */
    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory rabbitConnectionFactory) {
        final RabbitAdmin rabbitAdmin = new RabbitAdmin(rabbitConnectionFactory);

        // exchange 등록
        rabbitExchange(rabbitAdmin);
        ///queue 자동 등록
        for (SampleRabbitQueue sampleRabbitQueue : SampleRabbitQueue.values()) {
            rabbitAdmin.declareQueue(new Queue(sampleRabbitQueue.getQueueName(), true));
            rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue(sampleRabbitQueue.getQueueName(), true))
                    .to(rabbitExchange(rabbitAdmin)).with(sampleRabbitQueue.getQueueName()));
        }

        rabbitAdmin.afterPropertiesSet();
        return rabbitAdmin;
    }

    @Bean
    TopicExchange rabbitExchange(RabbitAdmin rabbitAdmin) {
        TopicExchange topicExchange = new TopicExchange(RABBIT_SAMPLE_EXCHANGE_NAME);
        topicExchange.setAdminsThatShouldDeclare(rabbitAdmin);
        return topicExchange;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory rabbitConnectionFactory,
                                         MessageConverter rabbitMessageConverter) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(rabbitConnectionFactory);
        rabbitTemplate.setMessageConverter(rabbitMessageConverter);
        rabbitTemplate.setExchange(RABBIT_SAMPLE_EXCHANGE_NAME);

        rabbitTemplate.setConfirmCallback(((correlationData, ack, cause) -> {
            if (ack) {
                log.info("success");
            } else {
                log.error("error {}", cause);
            }
        }));

        return rabbitTemplate;
    }
}
