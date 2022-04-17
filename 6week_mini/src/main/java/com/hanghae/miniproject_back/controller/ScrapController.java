package com.hanghae.miniproject_back.controller;


import com.hanghae.miniproject_back.dto.ScrapResponseDto;
import com.hanghae.miniproject_back.model.Contents;
import com.hanghae.miniproject_back.model.ScrapContents;
import com.hanghae.miniproject_back.security.UserDetailsImpl;
import com.hanghae.miniproject_back.service.ScrapSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class ScrapController {

    private final ScrapSerivce scrapSerivce;

    // 스크랩 등록
    @PostMapping("/post/{postId}/scrap")
    public ScrapContents createScrap(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        String username = userDetails.getUser().getName();
        return scrapSerivce.createScrap(postId,username);
    }

    // 스크랩 게시물 불러오기
    @GetMapping("/post/scrap")
    public List<ScrapContents> getContents(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return scrapSerivce.scrapread(userDetails);
    }

    // 스크랩 삭제
    @DeleteMapping("/post/scrap/{scrapId}")
    public Long deleteScrap(@PathVariable Long scrapId) {
        return scrapSerivce.deleteScrap(scrapId);
//
    }

}
