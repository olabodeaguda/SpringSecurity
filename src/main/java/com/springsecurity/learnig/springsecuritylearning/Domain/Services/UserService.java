package com.springsecurity.learnig.springsecuritylearning.Domain.Services;

import com.springsecurity.learnig.springsecuritylearning.Domain.Models.Role;
import com.springsecurity.learnig.springsecuritylearning.Domain.Models.User;

import java.util.List;

public interface UserService {
 User save(User user);
 Role saveRole(Role role);
 void addRoleToUser(String username, String roleName);
 User getUser(String username);
 List<User> getUsers();
}
