package com.example.demo.application.learning.service;

import com.example.demo.application.learning.dao.UserRepository;
import com.example.demo.application.learning.entity.UserDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserDetailsEntity createUser(UserDetailsEntity user){
        return userRepository.save(user);
    }

    public List<UserDetailsEntity> createUsers(List<UserDetailsEntity> users){
        return userRepository.saveAll(users);
    }

    public List<UserDetailsEntity> getAllUserDetails(){
        return userRepository.findAll();
    }

    public UserDetailsEntity getUserById(int id){
        return  userRepository.findById(id).orElse(new UserDetailsEntity());
    }

    public UserDetailsEntity updateUserDetails(UserDetailsEntity user){
        UserDetailsEntity oldUser = null;
        Optional<UserDetailsEntity> optionalUserDetails = userRepository.findById(user.getId());
        if(optionalUserDetails.isPresent()){
            oldUser = optionalUserDetails.get();
            oldUser.setUserName(user.getUserName());
            oldUser.setUserAddress(user.getUserAddress());
            userRepository.save(oldUser);
        }
        else {
            return(new UserDetailsEntity()); // have to handle error for this scenario //
        }
        return oldUser;
    }

    public String deleteUser(int id){
        userRepository.deleteById(id);
        return "UserDetails are deleted successfully";
    }
}
