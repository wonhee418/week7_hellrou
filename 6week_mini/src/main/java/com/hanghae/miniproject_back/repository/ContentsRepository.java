package com.hanghae.miniproject_back.repository;

import com.hanghae.miniproject_back.model.Contents;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContentsRepository extends JpaRepository<Contents, Long> {
    List<Contents> findAllByOrderByCreatedAtDesc();
    List<Contents> findAllByUsername(String username);
}
