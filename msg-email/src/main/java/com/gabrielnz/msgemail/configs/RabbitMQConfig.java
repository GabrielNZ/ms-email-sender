package com.gabrielnz.msgemail.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${broker.queue.email.name}")
    private String emailQueue;

    @Bean
    public Queue queue() {
        return new Queue(emailQueue, true);
    }
}
