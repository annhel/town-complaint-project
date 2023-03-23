package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.entity.Complaint;
import com.revature.towncomplaintproject.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService{

    @Autowired
    ComplaintRepository complaintRepository;


    @Override
    public Complaint insert(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint getById(Long id) {
        return complaintRepository.findById(id).get();
    }

    @Override
    public List<Complaint> getAll() {
        return complaintRepository.findAll();
    }

    @Override
    public Complaint update(Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public boolean delete(Long id) {
        boolean found = complaintRepository.existsById(id);
        if(found) complaintRepository.deleteById(id);
        return found;
    }

    @Override
    public List<Complaint> getAll(String status){
        return complaintRepository.getByStatus(status);
    }

    @Override
    public List<Complaint> getByMeetingId(Long meetingId){
        return complaintRepository.findByMeetingId(meetingId);
    }
}
