package springcloud.rabbitmq.config;

public enum SampleRabbitQueue {
    SAMPLE_TASK("rabbit.sample"),
    READ("rabbit.read"),
    WRITE("rabbit.write"),
    EMPTY("rabbit.empty");

    private String queueName;

    SampleRabbitQueue(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueName() {
        return queueName;
    }

    public static SampleRabbitQueue find(String name) {
        for (SampleRabbitQueue queue : SampleRabbitQueue.values()) {
            if (queue.getQueueName().equalsIgnoreCase(name)) {
                return queue;
            }
        }
        return SampleRabbitQueue.EMPTY;
    }
}

