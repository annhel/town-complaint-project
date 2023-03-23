package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.entity.Complaint;
import com.revature.towncomplaintproject.repository.ComplaintRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ComplaintServiceTest {

    @Autowired ComplaintService complaintService;

    @MockBean(ComplaintRepository.class)
    private ComplaintRepository complaintRepository;

//    test CRUD
    @Test
    public void testInsert() {
        Complaint complaint = new Complaint("Subject", "Desc","STATUS", 1l, 1l);
        Complaint createdComplaint = new Complaint(1l,"Subject", "Desc","STATUS", 1l, 1l);
        Mockito.when(complaintRepository.save(complaint)).thenReturn(createdComplaint);
        Assertions.assertEquals(createdComplaint, complaintService.insert(complaint));
    }

    @Test
    public void testGetById(){
        Complaint expectedComplaint = new Complaint(1l, "Subject", "Desc","STATUS", 1l, 1l);
        Optional<Complaint> cOptional = Optional.of(expectedComplaint);
        Mockito.when(complaintRepository.findById(1l)).thenReturn(cOptional);

        Assertions.assertEquals(expectedComplaint, complaintService.getById(1l));
    }

    @Test
    public void testGetAll(){
        List<Complaint> allComplaints = new ArrayList<>();
        allComplaints.add(new Complaint("Subject1", "Desc1","STATUS1", 1l, 1l));
        allComplaints.add(new Complaint("Subject2", "Desc2","STATUS2", 2l, 2l));
        allComplaints.add(new Complaint("Subject3", "Desc3","STATUS3", 3l, 3l));
        Mockito.when(complaintRepository.findAll()).thenReturn(allComplaints);
        Assertions.assertEquals(allComplaints, complaintService.getAll());
    }

    @Test
    public void testUpdate(){
        Complaint complaint = new Complaint("Subject", "Desc","STATUS", 1l, 1l);
        Complaint updatedComplaint = new Complaint(1l,"updatedSubject", "updatedDesc","updatedSTATUS", 1l, 1l);
        Mockito.when(complaintRepository.save(updatedComplaint)).thenReturn(updatedComplaint);
        Assertions.assertEquals(updatedComplaint, complaintService.update(updatedComplaint));

    }

    @Test
    public void delete(){
        List<Complaint> allComplaints = new ArrayList<>();
        allComplaints.add(new Complaint("Subject1", "Desc1","STATUS1", 1l, 1l));
        Mockito.when(complaintRepository.existsById(1l)).thenReturn(true);
        Assertions.assertEquals(true, complaintService.delete(1l));
    }
}
