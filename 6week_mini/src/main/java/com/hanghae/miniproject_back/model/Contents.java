package com.hanghae.miniproject_back.model;

import com.hanghae.miniproject_back.dto.ContentsRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Contents extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id; //Conternts_id //PK 변하지않는 유니크한 키값

//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
//    private Long postId;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String des;

    @Column
    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;


    // 게시물 생성관련
    public Contents(ContentsRequestDto requestDto ,String username) {
        this.username = username;
        this.title = requestDto.getTitle();
        this.des = requestDto.getDes();
        this.day1 = requestDto.getDay1();
        this.day2 = requestDto.getDay2();
        this.day3 = requestDto.getDay3();
        this.day4 = requestDto.getDay4();
        this.day5 = requestDto.getDay5();
        this.day6 = requestDto.getDay6();
        this.day7 = requestDto.getDay7();
    }
    // 게시물 수정관련
    public void update(ContentsRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.des = requestDto.getDes();
        this.day1 = requestDto.getDay1();
        this.day2 = requestDto.getDay2();
        this.day3 = requestDto.getDay3();
        this.day4 = requestDto.getDay4();
        this.day5 = requestDto.getDay5();
        this.day6 = requestDto.getDay6();
        this.day7 = requestDto.getDay7();
    }


}
