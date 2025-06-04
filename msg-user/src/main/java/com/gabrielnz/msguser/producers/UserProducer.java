package com.gabrielnz.msguser.producers;

import com.gabrielnz.msguser.entities.DTO.EmailDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(EmailDTO emailDTO) {
        rabbitTemplate.convertAndSend("",routingKey, emailDTO);
    }
}
