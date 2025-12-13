package com.alex.skill_swap.service;

import com.alex.skill_swap.model.User;
import com.alex.skill_swap.repository.UserRepository;
import org.springframework.stereotype.Service;



@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User createNewUser(User user) {
        user.setId(null);
       return userRepository.save(user);
    }

}
