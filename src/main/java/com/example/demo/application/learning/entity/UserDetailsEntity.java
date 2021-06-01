package com.example.demo.application.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="USER_DETAILS")
public class UserDetailsEntity {
    @Id
    @GeneratedValue
    private  Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_address")
    private String userAddress;
}
