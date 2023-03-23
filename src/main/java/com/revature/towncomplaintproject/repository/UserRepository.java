package com.revature.towncomplaintproject.repository;

import com.revature.towncomplaintproject.dto.LoginRequest;
import com.revature.towncomplaintproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM Users WHERE username = ?", nativeQuery = true)
    User getByUsername(String username);

//    @Query(value = "SELECT * FROM Users WHERE user_id = ?", nativeQuery = true)
//    User getById(Long id);
}
