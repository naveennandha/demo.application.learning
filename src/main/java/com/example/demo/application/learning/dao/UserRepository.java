package com.example.demo.application.learning.dao;

import com.example.demo.application.learning.entity.UserDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetailsEntity, Integer> {
}
