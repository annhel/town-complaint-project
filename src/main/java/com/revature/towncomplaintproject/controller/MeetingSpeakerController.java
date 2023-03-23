package com.revature.towncomplaintproject.controller;

import com.revature.towncomplaintproject.dto.SpeakerInfoReturn;
import com.revature.towncomplaintproject.entity.MeetingSpeaker;
import com.revature.towncomplaintproject.service.MeetingSpeakerService;
import org.apache.coyote.Response;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speakers")
@CrossOrigin("*")
public class MeetingSpeakerController {

    @Autowired
    MeetingSpeakerService meetingSpeakerService;

//    @PostMapping
//    ResponseEntity<MeetingSpeaker> addSpeakersByMeetingId(@RequestBody MeetingSpeaker meetingSpeaker){
//        MeetingSpeaker savedSpeaker = meetingSpeakerService.insert(meetingSpeaker);
//        return ResponseEntity.ok(savedSpeaker);
//    }

    //speakers?meetingId=101 => get speakers for that meeting
    @GetMapping("/{id}")
    ResponseEntity<List<SpeakerInfoReturn>> getSpeakersByMeetingId(@PathVariable("id") Long id){
        List<SpeakerInfoReturn> speakers = meetingSpeakerService.getSpeakersByMeetingId(id);
        return ResponseEntity.ok(speakers);
    }

}
