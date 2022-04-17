package com.hanghae.miniproject_back.service;

import com.hanghae.miniproject_back.dto.SignupRequestDto;
import com.hanghae.miniproject_back.model.User;
import com.hanghae.miniproject_back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public User registerUser(SignupRequestDto requestDto) {
        Optional<User> found1 = userRepository.findByUserId(requestDto.getUserId());
        Optional<User> found2 = userRepository.findByName(requestDto.getName());


        if (found1.isPresent()) {
            throw new IllegalArgumentException("이미 가입된 회원입니다.");
        }
        if (found2.isPresent()) {
            throw new IllegalArgumentException("중복된 닉네임입니다.");
        }


        User user = User.builder()
                .name(requestDto.getName())
                .userId(requestDto.getUserId())
                .pw(passwordEncoder.encode(requestDto.getPw()))
                .build();
       return userRepository.save(user);
//        Optional<User> savedUser = userRepository.findByUsername(username);
//        Long uid = savedUser.get().getUid();
//        Boolean ok = true;
//        SignupResponseDto responseDto = new SignupResponseDto(uid, username, nickname, email, ok);
//        return responseDto;

    }

}


