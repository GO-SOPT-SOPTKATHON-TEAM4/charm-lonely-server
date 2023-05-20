package com.sopt.sopkathonproduct.dto.response;

import com.sopt.sopkathonproduct.domain.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDTO {

    private Long postId;
    private String nickname;
    private String imageUrl;
    private String comment;

    public static PostResponseDTO of(Post post) {
        return new PostResponseDTO(post.getId(), post.getNickname(), post.getImageUrl(), post.getComment());
    }
}
