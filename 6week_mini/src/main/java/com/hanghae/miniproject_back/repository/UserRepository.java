package com.hanghae.miniproject_back.repository;

import com.hanghae.miniproject_back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>  {
    Optional<User> findByUserId(String userId);
//    Optional<User> findByUsername(String username);
    Optional<User> findByName(String name);
//    Optional<User> findByUsername(String username);
}
