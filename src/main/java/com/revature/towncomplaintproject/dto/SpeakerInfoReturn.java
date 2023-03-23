package com.revature.towncomplaintproject.dto;

import com.revature.towncomplaintproject.entity.User;
import lombok.Data;

@Data
public class SpeakerInfoReturn {
    private long user_id;
    private String fname;
    private String lname;

    public SpeakerInfoReturn(User user){
        this.user_id = user.getUser_id();
        this.fname = user.getFname();
        this.lname = user.getLname();
    }
}
