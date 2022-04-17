package com.hanghae.miniproject_back.controller;

import com.hanghae.miniproject_back.dto.ContentsRequestDto;
import com.hanghae.miniproject_back.model.Contents;
import com.hanghae.miniproject_back.model.ScrapContents;
import com.hanghae.miniproject_back.repository.ContentsRepository;
import com.hanghae.miniproject_back.security.UserDetailsImpl;
import com.hanghae.miniproject_back.service.ContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;


@RequiredArgsConstructor
@RestController
public class ContentsController {
    private  final ContentsService contentsService;

    // 메인페이지 헬스투린 불러오기
    @GetMapping("/")
    public List<Contents> getContents() {
        return contentsService.mainread();
    }

    // 헬스루틴 등록
    @PostMapping("/contents/post")
    public Contents postContents(@RequestBody ContentsRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUsername();
        return contentsService.postContents(requestDto, username);
    }
    // 타임스탬프시간 맞추기
    @PostConstruct
    public void started(){
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
    }


    // 상세페이지 헬스루틴 조회하기
    @GetMapping("/contents/detail/{postId}")
    public Contents readContent(@PathVariable Long postId){
        return contentsService.readContent(postId);
    }

    // 게시글 수정
    @PatchMapping ("/contents/post/{postId}")
    public Long updateContents(@PathVariable Long postId, @RequestBody ContentsRequestDto requestDto) {
        contentsService.update(postId, requestDto);
        return postId;
    }
    // 게시글 삭제
    @DeleteMapping("/contents/post/{postId}")
    public Long deleteContents(@PathVariable Long postId) {
        return contentsService.deleteContent(postId);
    }

    // 내가 등록한 게시글
    @GetMapping("/contents/mypost")
    public List<Contents> getMyContents(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return contentsService.getMyContents(userDetails);
    }


}
