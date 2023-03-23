package com.revature.towncomplaintproject.service;
import com.revature.towncomplaintproject.entity.Meeting;
import com.revature.towncomplaintproject.repository.MeetingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MeetingServiceTest {

    @Autowired
    MeetingService meetingService;

    @MockBean(MeetingRepository.class)
    private MeetingRepository meetingRepository;

    @Test
    public void testInsert(){
        Meeting meeting = new Meeting("Title1","Desc1", "Address1","Link1",1l );
        Meeting expectedMeeting = new Meeting(1l,"Title1","Desc1", "Address1","Link1",1l );

        Mockito.when(meetingRepository.save(meeting)).thenReturn(expectedMeeting);

        Assertions.assertEquals(expectedMeeting, meetingService.insert(meeting));
    }

    @Test
    public void testGetAll(){
        List<Meeting> allMeetings = new ArrayList<>();

        allMeetings.add(new Meeting("Title1","Desc1", "Address1","Link1",1l ));
        allMeetings.add(new Meeting("Title2","Desc2", "Address2","Link2",2l ));
        allMeetings.add(new Meeting("Title3","Desc3", "Address3","Link3",3l ));

        Mockito.when(meetingRepository.findAll()).thenReturn(allMeetings);

        Assertions.assertEquals(allMeetings, meetingService.getAll());

    }

    @Test
    public void testGetById(){

        Meeting expectedMeeting = new Meeting("Title1","Desc1", "Address1","Link1",1l );
        Optional<Meeting> meetingOptional = Optional.of(expectedMeeting);
        Mockito.when(meetingRepository.findById(1l)).thenReturn(meetingOptional);

        Assertions.assertEquals(expectedMeeting, meetingService.getById(1l));
    }

    @Test
    public void testUpdate(){
        Meeting originalMeeting = new Meeting("Title1","Desc1",  "Address1","Link1",1l );

        Meeting expectedMeeting = new Meeting(1l,"UpdatedTitle1","UpdatedDesc1", "UpdatedAddress1","UpdatedLink1",1l );

        Mockito.when(meetingRepository.save(expectedMeeting)).thenReturn(expectedMeeting);

        Assertions.assertEquals(expectedMeeting, meetingService.update(expectedMeeting));
    }

    @Test
    public void delete(){
        List<Meeting> allMeetings = new ArrayList<>();


        allMeetings.add(new Meeting("Title1","Desc1", "Address1","Link1",1l ));
        allMeetings.add(new Meeting("Title2","Desc2", "Address2","Link2",2l ));

        Mockito.when(meetingRepository.existsById(1l)).thenReturn(true);

        Assertions.assertEquals(true, meetingService.delete(1l));
    }

}
