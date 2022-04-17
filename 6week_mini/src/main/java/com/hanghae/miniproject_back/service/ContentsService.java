package com.hanghae.miniproject_back.service;

import com.hanghae.miniproject_back.dto.ContentsRequestDto;
import com.hanghae.miniproject_back.model.Contents;
import com.hanghae.miniproject_back.repository.ContentsRepository;
import com.hanghae.miniproject_back.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ContentsService {

    private final ContentsRepository contentsRepository;

    // 게시물 생성
    @Transactional
    public Contents postContents(ContentsRequestDto requestDto, String username) {
        Contents contents = new Contents(requestDto, username);
        return contentsRepository.save(contents);
    }

    // 상세페이지 게시물 조회하기
    public Contents readContent(Long postId) {
        return contentsRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다."));
    }

    // 게시물 수정
    @Transactional
    public Long update(Long postId, ContentsRequestDto requestDto) {
        Contents contents = contentsRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        contents.update(requestDto);
        return contents.getId();
    }

    //게시물 삭제하기
    public Long deleteContent(Long postId) {
        contentsRepository.deleteById(postId);
        return postId;
    }

    // 메인페이지 리스트
    public List<Contents> mainread() {
       return contentsRepository.findAllByOrderByCreatedAtDesc();
    }

    // 내가 등록한 게시글
    public List<Contents> getMyContents(UserDetailsImpl userDetails) {
        return contentsRepository.findAllByUsername(userDetails.getUser().getUserId());
    }

}
