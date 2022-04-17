package com.hanghae.miniproject_back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SignupRequestDto {
    private String userId;
    private String name;
    private String pw;
}
