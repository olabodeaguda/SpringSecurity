package com.springsecurity.learnig.springsecuritylearning.Api;


import com.springsecurity.learnig.springsecuritylearning.Domain.Models.Role;
import com.springsecurity.learnig.springsecuritylearning.Domain.Models.User;
import com.springsecurity.learnig.springsecuritylearning.Domain.Services.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return  ResponseEntity.ok().body(userService.getUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> getUsers(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

        return  ResponseEntity.created(uri).body(userService.save(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> SaveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return  ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> SaveRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRolename());
        return  ResponseEntity.ok().build();
    }


    @GetMapping("/refreshtoken")
    public ResponseEntity<List<User>> refreshToken(HttpServletRequest request, HttpServletResponse response) {

        return  ResponseEntity.ok().body(userService.getUsers());
    }

}

@Data
class RoleToUserForm
{
    private String username;
    private String rolename;
}
