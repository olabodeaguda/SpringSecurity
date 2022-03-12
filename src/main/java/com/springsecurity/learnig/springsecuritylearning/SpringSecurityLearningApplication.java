package com.springsecurity.learnig.springsecuritylearning;

import com.springsecurity.learnig.springsecuritylearning.Domain.Models.Role;
import com.springsecurity.learnig.springsecuritylearning.Domain.Models.User;
import com.springsecurity.learnig.springsecuritylearning.Domain.Services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityLearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearningApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.save(new User(null,"Aguda Olabode1","aolabode1","1234",new ArrayList<Role>()));
            userService.save(new User(null,"Aguda Olabode2","aolabode2","1234",new ArrayList<Role>()));
            userService.save(new User(null,"Aguda Olabode3","aolabode3","1234",new ArrayList<Role>()));
            userService.save(new User(null,"Aguda Olabode4","aolabode4","1234",new ArrayList<Role>()));

            userService.addRoleToUser("aolabode1","ROLE_ADMIN");
            userService.addRoleToUser("aolabode2","ROLE_MANAGER");
            userService.addRoleToUser("aolabode3","ROLE_SUPER_ADMIN");
            userService.addRoleToUser("aolabode4","ROLE_USER");
        };
    }
}
