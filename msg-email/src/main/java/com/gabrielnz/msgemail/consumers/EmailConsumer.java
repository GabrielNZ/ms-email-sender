package com.gabrielnz.msgemail.consumers;

import com.gabrielnz.msgemail.entities.DTO.EmailDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listEmailQueue(@Payload EmailDTO email) {
        System.out.println(email.emailTo());
    }
}
