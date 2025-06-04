package com.gabrielnz.msguser.services;

import com.gabrielnz.msguser.entities.DTO.EmailDTO;
import com.gabrielnz.msguser.entities.User;
import com.gabrielnz.msguser.producers.UserProducer;
import com.gabrielnz.msguser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProducer userProducer;

    @Transactional
    public User saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            EmailDTO emailDTO = new EmailDTO(user.getUserId(),user.getEmail(),"Tentativa de registro", user.getName()+", algum novo usuario tentou registrar esse email! Caso tenha sido voce, entre em contato ->");
            userProducer.publishMessageEmail(emailDTO);
            return null;
        }
        var userModel = userRepository.save(user);
        EmailDTO emailDTO = new EmailDTO(user.getUserId(),user.getEmail(),"Cadastro realizado com sucesso", user.getName()+", seja bem vindo(a)!\n Agradecemos o seu cadastro, aproveite as novidades e beneficios do programa...");
        userProducer.publishMessageEmail(emailDTO);
        return userModel;
    }
}
