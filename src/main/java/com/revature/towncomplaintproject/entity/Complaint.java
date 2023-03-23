package com.revature.towncomplaintproject.entity;


import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Complaints")
@Entity
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long complaint_id;
    private String subject;
    private String description;
    private String status;
    private Long user_id;
    private Long meeting_id;

    public Complaint(String subject, String description, String status, Long meeting_id, Long user_id){
        this.subject = subject;
        this.description = description;
        this.status = status;
        this.meeting_id = meeting_id;
        this.user_id = user_id;
    }
}
