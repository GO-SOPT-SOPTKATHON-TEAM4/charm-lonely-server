package com.sopt.sopkathonproduct.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long id;
    private String nickname;
    private String imageUrl;
    private String comment;

    public static PostResponseDto of(Long id, String nickname, String imageUrl, String comment) {
        return new PostResponseDto(id, nickname, imageUrl, comment);
    }
}
