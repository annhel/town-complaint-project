package com.revature.towncomplaintproject.controller;

import com.revature.towncomplaintproject.dto.LoginRequest;
import com.revature.towncomplaintproject.entity.Complaint;
import com.revature.towncomplaintproject.service.ComplaintService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
@RequestMapping("/complaints")
@CrossOrigin("*") //"localhost:3000"
public class ComplaintController {

    Logger logger1 = LoggerFactory.getLogger(ComplaintController.class);

    @Autowired
    ComplaintService complaintService;

    @PostMapping()
    Complaint insert(@RequestBody Complaint complaint){
        return complaintService.insert(complaint);
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    List<Complaint> getAll(@RequestParam(required = false, value="status")String status){
        if(status == null) return complaintService.getAll();
        else return complaintService.getAll(status);
    }

//    @GetMapping("/{id}")
//    Complaint getById(@PathVariable("id") Long id){
//        return complaintService.getById(id);
//    }

    @GetMapping("/{meeting_id}")
    List<Complaint> getByMeetingId(@PathVariable("meeting_id") Long meetingId){
        return complaintService.getByMeetingId(meetingId);
    }

    @PutMapping()
    Complaint update(@RequestBody Complaint complaint){
        return complaintService.update(complaint);
    }

    @DeleteMapping("/{id}")
    boolean delete(@PathVariable("id") Long id){
        return complaintService.delete(id);
    }


}
