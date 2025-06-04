package com.gabrielnz.msguser.services;

import com.gabrielnz.msguser.entities.User;
import com.gabrielnz.msguser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User saveUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) != null) {
            return null;
        }
        return userRepository.save(user);
    }
}
