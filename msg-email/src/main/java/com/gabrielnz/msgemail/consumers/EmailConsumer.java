package com.gabrielnz.msgemail.consumers;

import com.gabrielnz.msgemail.entities.DTO.EmailDTO;
import com.gabrielnz.msgemail.entities.Email;
import com.gabrielnz.msgemail.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = "${broker.queue.email.name}")
    public void listEmailQueue(@Payload EmailDTO emailDTO) {
        var email = new Email();
        BeanUtils.copyProperties(emailDTO, email);
        emailService.sendEmail(email);
    }
}