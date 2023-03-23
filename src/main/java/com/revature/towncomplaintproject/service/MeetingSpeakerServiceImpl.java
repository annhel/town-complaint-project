package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.dto.SpeakerInfoReturn;
import com.revature.towncomplaintproject.entity.MeetingSpeaker;
import com.revature.towncomplaintproject.entity.User;
import com.revature.towncomplaintproject.repository.MeetingSpeakerRepository;
import com.revature.towncomplaintproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MeetingSpeakerServiceImpl implements MeetingSpeakerService{

    @Autowired
    MeetingSpeakerRepository meetingSpeakerRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public MeetingSpeaker insert(MeetingSpeaker meetingSpeaker) {
        return meetingSpeakerRepository.save(meetingSpeaker);
    }

    @Override
    public List<SpeakerInfoReturn> getSpeakersByMeetingId(Long id) {
        List<MeetingSpeaker> meetingSpeakers = meetingSpeakerRepository.getByMeetingId(id);
        List<SpeakerInfoReturn> speakerInfo = new ArrayList<>();

        System.out.println(meetingSpeakers);

        if(meetingSpeakers.size() == 0) return speakerInfo;

        System.out.println(meetingSpeakers);
        for(int i = 0; i < meetingSpeakers.size(); i++){
            Long user_id = meetingSpeakers.get(i).getUser().getUser_id();
            User user = userRepository.getById(user_id);
            speakerInfo.add(new SpeakerInfoReturn(user));
        }

        return speakerInfo;

    }
}
