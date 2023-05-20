package com.sopt.sopkathonproduct.controller;

import com.sopt.sopkathonproduct.common.dto.ApiResponseDto;
import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.response.PostResponseDto;
import com.sopt.sopkathonproduct.exception.SuccessStatus;
import com.sopt.sopkathonproduct.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/{postId}")
    public ApiResponseDto getPost(@PathVariable Long postId) {
        Post response = postService.getById(postId);
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, PostResponseDto.of(response.getId(), response.getNickname(), response.getImageUrl(), response.getComment()));
    }
}
