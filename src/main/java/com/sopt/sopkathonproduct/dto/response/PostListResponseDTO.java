package com.sopt.sopkathonproduct.dto.response;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostListResponseDTO {
    List<PostResponseDTO> posts;

    public PostListResponseDTO(List<PostResponseDTO> posts) {
        this.posts = posts;
    }
}
