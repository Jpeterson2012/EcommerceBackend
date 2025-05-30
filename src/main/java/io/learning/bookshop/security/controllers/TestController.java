package io.learning.bookshop.security.controllers;

import io.learning.bookshop.books.Books;
import io.learning.bookshop.security.Repositories.Customuser;
import io.learning.bookshop.security.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import io.learning.bookshop.security.Models.*;
import io.learning.bookshop.security.Repositories.UserRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;

@CrossOrigin(origins = {"${fe.url}"}, maxAge = 3600, allowCredentials = "true")
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/api/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
//    @Autowired
//    private static UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Customuser> getUsers(){
       return userService.getUsers();
    }

    @PutMapping("/role/{userid}")
    @PreAuthorize("hasRole('ADMIN')")
    public void setNewRole(@PathVariable int userid, @RequestBody int roleid) {userService.setNewRole(userid, roleid);}

    @PutMapping("/pw{userid}")
    @PreAuthorize("hasRole('ADMIN')")
    public void resetPassword(@PathVariable int userid, @RequestBody String pw){
        logger.info("The path variable 'user' is: {}", userid);
        logger.info("The path variable 'pw' is: {}", pw);
        userService.resetPassword(userid, encoder.encode(pw));
    }

}
