package com.revature.towncomplaintproject.entity;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Meetings")
@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meeting_id;
    private String title;
    private String description;
    private String address;
    private String meeting_link;
    private Long date;

//    @OneToMany(mappedBy = "meeting")
//    private List<MeetingSpeaker> speakers = new ArrayList<>();

    public Meeting(String title, String description, String address, String meeting_link,Long date){
        this.title = title;
        this.description = description;
        this.address = address;
        this.meeting_link = meeting_link;
        this.date = date;
    }
}
