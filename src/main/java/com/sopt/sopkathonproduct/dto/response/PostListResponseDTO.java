package com.sopt.sopkathonproduct.dto.response;

import com.sopt.sopkathonproduct.domain.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostListResponseDTO {
    List<PostResponseDTO> posts;

    public static PostListResponseDTO of(List<Post> posts) {
        return new PostListResponseDTO(posts.stream().map(PostResponseDTO::of).collect(Collectors.toList()));
    }

}
