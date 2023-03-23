package com.revature.towncomplaintproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String password;
    private String fname;
    private String lname;
    private String role;

//    @OneToMany(mappedBy = "user")
//    private List<MeetingSpeaker> speakers = new ArrayList<>();

    public User(String username, String password, String fname, String lname, String role){
        this.username = username;
        this.password = password;
        this.fname = fname;
        this.lname = lname;
        this.role = role;
    }

}
