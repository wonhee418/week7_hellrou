package com.hanghae.miniproject_back.repository;

import com.hanghae.miniproject_back.model.Contents;
import com.hanghae.miniproject_back.model.ScrapContents;
import com.hanghae.miniproject_back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ScrapRepository extends JpaRepository<ScrapContents, Long> {
    List<ScrapContents> findAllByOrderByCreatedAtDesc();
    List<ScrapContents> findAllByUsername(String username);

}
