package com.revature.towncomplaintproject.controller;

import com.revature.towncomplaintproject.dto.LoginRequest;
import com.revature.towncomplaintproject.dto.UserInfoReturn;
import com.revature.towncomplaintproject.entity.User;
import com.revature.towncomplaintproject.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class UserController {

//    @PatchMapping()
//    public User loginRequest

    Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);

    @Autowired
    UserService userService;

    @PostMapping()
    User insert(@RequestBody User user){
        return userService.insert(user);
    }


    @PatchMapping()
    public ResponseEntity <UserInfoReturn> login(@RequestBody LoginRequest loginRequest){ // user and pass from frontend

        User userInfo = null;
        try{
            userInfo = userService.getByUsername(loginRequest.getUsername());
        }catch(Exception e){
            return ResponseEntity.status(404).build();
        }
        //check passwords
        if(loginRequest.getPassword().equals(userInfo.getPassword())){
            UserInfoReturn userInfoReturn = new UserInfoReturn(userInfo);
            return ResponseEntity.ok(userInfoReturn);
        } else {
            return ResponseEntity.status(422).build();
        }

    }
}
