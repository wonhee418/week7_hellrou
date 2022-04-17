package com.hanghae.miniproject_back.service;


import com.hanghae.miniproject_back.dto.ScrapResponseDto;
import com.hanghae.miniproject_back.model.Contents;
import com.hanghae.miniproject_back.model.ScrapContents;
import com.hanghae.miniproject_back.repository.ContentsRepository;
import com.hanghae.miniproject_back.repository.ScrapRepository;
import com.hanghae.miniproject_back.repository.UserRepository;
import com.hanghae.miniproject_back.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ScrapSerivce {

    private final ScrapRepository scrapRepository;
    private final ContentsRepository contentsRepository ;
    private final UserRepository userRepository ;

    @Transactional
    public ScrapContents createScrap(Long postId, String username) {
        Contents contents = contentsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
        ScrapContents scrapContents = new ScrapContents(username, contents);
        return scrapRepository.save(scrapContents);
    }

    // 스크랩 불러오기
    public List<ScrapContents> scrapread(UserDetailsImpl userDetails) {
         return scrapRepository.findAllByUsername(userDetails.getUsername());
    }



    // 스크랩 삭제하기
    public Long deleteScrap(Long scrapId) {
        scrapRepository.deleteById(scrapId);
        return scrapId;

    }
}


