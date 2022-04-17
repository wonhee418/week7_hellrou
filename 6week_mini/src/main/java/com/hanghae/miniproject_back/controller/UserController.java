package com.hanghae.miniproject_back.controller;


import com.hanghae.miniproject_back.dto.SignupRequestDto;
import com.hanghae.miniproject_back.dto.UserInfoDto;
import com.hanghae.miniproject_back.model.User;
import com.hanghae.miniproject_back.security.UserDetailsImpl;
import com.hanghae.miniproject_back.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //회원 가입
    @PostMapping("/user/signup")
    public User registerUser(@RequestBody SignupRequestDto userDto){
        return userService.registerUser(userDto);
    }


    //닉네임주기
    @PostMapping("/user/userinfo")
    @ResponseBody
    public UserInfoDto getUserInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new UserInfoDto(userDetails.getUser().getName());
    }
}

