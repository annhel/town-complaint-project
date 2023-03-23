package com.revature.towncomplaintproject.controller;

import com.revature.towncomplaintproject.dto.SpeakerInfoReturn;
import com.revature.towncomplaintproject.entity.Meeting;
import com.revature.towncomplaintproject.entity.MeetingSpeaker;
import com.revature.towncomplaintproject.entity.User;
import com.revature.towncomplaintproject.service.MeetingService;
import com.revature.towncomplaintproject.service.MeetingSpeakerService;
import com.revature.towncomplaintproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
@CrossOrigin("*")
public class MeetingController {

    @Autowired
    MeetingService meetingService;

    @Autowired
    UserService userService;

    @Autowired
    MeetingSpeakerService meetingSpeakerService;

    @PostMapping()
    Meeting insert(@RequestBody Meeting meeting){
        return meetingService.insert(meeting);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    List<Meeting> getAll(){
        return meetingService.getAll();
    }

    @GetMapping("/{id}")
    Meeting getById(@PathVariable("id") Long id){
        return meetingService.getById(id);
    }

    @PutMapping()
    Meeting update(@RequestBody Meeting meeting){
        return meetingService.update(meeting);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id){
        return meetingService.delete(id);
    }

//    patch meetings/29/addspeaker
    @PatchMapping("/{meeting_id}/speakers/{user_id}")
    ResponseEntity<MeetingSpeaker> addSpeakersById(@PathVariable("meeting_id") Long meeting_id,@PathVariable("user_id")  Long user_id){
        Meeting meeting = meetingService.getById(meeting_id);
        User user = userService.getById(user_id);
        MeetingSpeaker newSpeaker = meetingSpeakerService.insert(new MeetingSpeaker(meeting, user));
        return ResponseEntity.ok(newSpeaker);
    }

}
