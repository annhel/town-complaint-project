package com.revature.towncomplaintproject.repository;

import com.revature.towncomplaintproject.entity.MeetingSpeaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MeetingSpeakerRepository extends JpaRepository<MeetingSpeaker, Long> {

    @Query(value = "SELECT * FROM Meeting_Speaker WHERE meeting_id = ?", nativeQuery = true)
    List<MeetingSpeaker> getByMeetingId(Long meetingId);
}
