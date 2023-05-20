package com.sopt.sopkathonproduct.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class RandomPostResponseDTO {
    private Long postId;
    private String nickname;
    private String imageUrl;
    private String comment;


    @Builder
    public RandomPostResponseDTO(Long postId, String nickname, String imageUrl, String comment) {
        this.postId = postId;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.comment = comment;
    }
}
