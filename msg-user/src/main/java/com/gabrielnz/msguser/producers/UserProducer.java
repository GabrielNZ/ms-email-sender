package com.gabrielnz.msguser.producers;

import com.gabrielnz.msguser.entities.DTO.EmailDTO;
import com.gabrielnz.msguser.entities.User;
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

    public void publishMessageEmail(User user){
        EmailDTO email = new EmailDTO(user.getUserId(), user.getEmail(), "Cadastro realizado com sucesso", user.getName()+", seja bem vindo(a)!\n Agradecemos o seu cadastro, aproveite as novidades e beneficios do programa...");
        rabbitTemplate.convertAndSend("",routingKey, email);
    }
}
