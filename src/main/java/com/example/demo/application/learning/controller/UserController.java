package com.example.demo.application.learning.controller;

import com.example.demo.application.learning.entity.UserDetailsEntity;
import com.example.demo.application.learning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/load")
    public String saveUser(){
        return  "home.xml";
    }

    @PostMapping("/addUser")
    public UserDetailsEntity saveUser(@RequestBody UserDetailsEntity user){
        String url = "google.com";


         return  userService.createUser(user);
    }

    @PostMapping("/addUsersList")
    public List<UserDetailsEntity> saveUsers(@RequestBody List<UserDetailsEntity> userDetailsList){
        return userService.createUsers(userDetailsList);
    }

    @GetMapping("/getAllUsers")
    public List<UserDetailsEntity> getAllUsers(){
        return userService.getAllUserDetails();
    }

    @GetMapping("/getUserById/{id}")
    public UserDetailsEntity getUserByID(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/updateUser")
    public UserDetailsEntity updateUserDetails(@RequestBody UserDetailsEntity newUser){
        return userService.updateUserDetails(newUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "User HAs been deleted Successfully";
    }
}
