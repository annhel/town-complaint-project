package com.revature.towncomplaintproject.service;

import com.revature.towncomplaintproject.dto.SpeakerInfoReturn;
import com.revature.towncomplaintproject.entity.MeetingSpeaker;

import java.util.List;

public interface MeetingSpeakerService {
    MeetingSpeaker insert(MeetingSpeaker meetingSpeaker);

    List<SpeakerInfoReturn> getSpeakersByMeetingId(Long id);
}
