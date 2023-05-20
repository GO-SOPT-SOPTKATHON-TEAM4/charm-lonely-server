package com.sopt.sopkathonproduct.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDTO {

    private Long postId;
    private String nickname;
    private String imageUrl;
    private String comment;

    public static PostResponseDTO of(Long postId, String nickname, String imageUrl, String comment) {
        return new PostResponseDTO(postId, nickname, imageUrl, comment);
    }
}
