package com.springsecurity.learnig.springsecuritylearning.Infrastructure.Data;

import com.springsecurity.learnig.springsecuritylearning.Domain.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
