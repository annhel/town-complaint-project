package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.dto.UserInfoReturn;
import com.revature.towncomplaintproject.entity.User;
import com.revature.towncomplaintproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getByUsername(String username){
        return userRepository.getByUsername(username);
    }
}
