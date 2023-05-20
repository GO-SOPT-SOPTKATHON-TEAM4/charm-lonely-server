package com.sopt.sopkathonproduct.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDTO {
    private Long postId;
    private String nickname;
    private String imageUrl;
    private String comment;

    @Builder
    public PostResponseDTO(Long postId, String nickname, String imageUrl, String comment) {
        this.postId = postId;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.comment = comment;
    }
}
