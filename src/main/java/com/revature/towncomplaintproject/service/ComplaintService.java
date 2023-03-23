package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.entity.Complaint;

import java.util.List;

public interface ComplaintService {

    Complaint insert(Complaint complaint);

    Complaint getById(Long id);

    List<Complaint> getByMeetingId(Long id);

    List<Complaint> getAll();

    List<Complaint> getAll(String status);

    Complaint update(Complaint complaint);

    boolean delete(Long id);


}
