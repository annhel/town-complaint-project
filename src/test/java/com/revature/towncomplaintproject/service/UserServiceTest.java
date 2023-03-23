package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.entity.User;
import com.revature.towncomplaintproject.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired UserService userService;

    @MockBean(UserRepository.class)
    private UserRepository userRepository;

    @Test
    public void testGetAll(){
        List<User> allUsers = new ArrayList<>();
        allUsers.add(new User("Username 1","Password 1","Larry","Wright","COUNCIL"));
        allUsers.add(new User("Username 2","Password 2","Will","James","CONSTITUENT"));

        Mockito.when(userRepository.findAll()).thenReturn(allUsers);

        Assertions.assertEquals(allUsers, userService.getAll());

    }


}
