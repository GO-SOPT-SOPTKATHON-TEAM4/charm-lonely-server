package com.sopt.sopkathonproduct.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long postId;
    private String nickname;
    private String imageUrl;
    private String comment;

    public static PostResponseDto of(Long postId, String nickname, String imageUrl, String comment) {
        return new PostResponseDto(postId, nickname, imageUrl, comment);
    }
}
