package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.dto.UserInfoReturn;
import com.revature.towncomplaintproject.entity.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> getAll();

    User insert(User user);

    User getByUsername(String username);

}
