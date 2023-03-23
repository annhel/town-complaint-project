package com.revature.towncomplaintproject.repository;

import com.revature.towncomplaintproject.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query(value = "Select * FROM Complaints WHERE status = ?", nativeQuery = true)
    List<Complaint> getByStatus(String status);

    @Query(value = "Select * FROM Complaints WHERE meeting_id = ?", nativeQuery = true)
    List<Complaint> findByMeetingId(Long id);
}
