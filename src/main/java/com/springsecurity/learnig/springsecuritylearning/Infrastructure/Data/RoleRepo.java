package com.springsecurity.learnig.springsecuritylearning.Infrastructure.Data;

import com.springsecurity.learnig.springsecuritylearning.Domain.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
