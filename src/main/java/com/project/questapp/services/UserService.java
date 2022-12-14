package com.project.questapp.services;

import com.project.questapp.entities.User;
import com.project.questapp.responses.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
   private UserRepository userRepository;//connection to repo
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User SaveOneUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getOneUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User updateOneUser(Long userId, User newUser) {
        Optional<User> user =userRepository.findById(userId);

        if(user.isPresent()){//if user exist
            User foundUser=user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        else{
            return null;
        }
    }

    public void deleteOneUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
