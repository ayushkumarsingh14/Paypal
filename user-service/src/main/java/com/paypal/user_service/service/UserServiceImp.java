package com.paypal.user_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.paypal.user_service.entity.User;
import com.paypal.user_service.repository.UserRepo;

@Service
public class UserServiceImp implements UserService {

    private UserRepo userRepo;

    public UserServiceImp (UserRepo userRepo){
        this.userRepo = userRepo;
    }



    @Override
    public User createUser(User user) {
        return (User) userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
}
