package com.hanghae.miniproject_back.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ScrapResponseDto {
    private String title;
    private String desc;
    private String modifiedAt;
}
