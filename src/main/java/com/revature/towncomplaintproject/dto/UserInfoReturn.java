package com.revature.towncomplaintproject.dto;

import com.revature.towncomplaintproject.entity.User;
import lombok.Data;

@Data
public class UserInfoReturn {
    private Long user_id;
    private String username;
    private String fname;
    private String lname;
    private String role;

    public UserInfoReturn(User user){
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.fname = user.getFname();
        this.lname = user.getLname();
        this.role = user.getRole();
    }
}
