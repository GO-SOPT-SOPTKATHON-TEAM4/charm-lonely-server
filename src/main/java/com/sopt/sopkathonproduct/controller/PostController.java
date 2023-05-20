package com.sopt.sopkathonproduct.controller;


import com.sopt.sopkathonproduct.common.dto.ApiResponseDto;
import com.sopt.sopkathonproduct.dto.request.UploadRequestDTO;
import com.sopt.sopkathonproduct.dto.response.PostListResponseDTO;
import com.sopt.sopkathonproduct.dto.response.PostResponseDTO;
import com.sopt.sopkathonproduct.dto.response.UploadResponseDTO;
import com.sopt.sopkathonproduct.exception.SuccessStatus;
import com.sopt.sopkathonproduct.service.PostService;
import com.sopt.sopkathonproduct.service.RankingService;
import com.sopt.sopkathonproduct.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final S3Service s3Service;
    private final RankingService rankingService;

    @CrossOrigin
    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseDto<UploadResponseDTO> uploadPost(
            @RequestPart MultipartFile image, UploadRequestDTO uploadRequestDto,
            HttpServletResponse response
    ) {
        UploadResponseDTO uploadResponseDTO = s3Service.uploadPost(image, uploadRequestDto);
        response.setHeader("Location", "api/posts/" + String.valueOf(uploadResponseDTO.getPostId()));
        return ApiResponseDto.success(SuccessStatus.UPLOAD_POST_SUCCESS, uploadResponseDTO);
    }

    @PatchMapping("/{postId}/ranking")
    public ApiResponseDto updateRanking(@PathVariable Long postId) {
        rankingService.updateRanking(postId);
        return ApiResponseDto.success(SuccessStatus.UPDATE_RANKING_SUCCESS);
    }

    @GetMapping("/tournament")
    public ApiResponseDto<PostListResponseDTO> getRandomImage() {
        List<PostResponseDTO> dtoList = postService.getRandom8Post();
        PostListResponseDTO postListResponseDTO = new PostListResponseDTO(dtoList);
        return ApiResponseDto.success(SuccessStatus.READ_POST_LIST_SUCCESS, postListResponseDTO);
    }

    @GetMapping("/{postId}")
    public ApiResponseDto<PostResponseDTO> getPost(@PathVariable Long postId) {
        PostResponseDTO response = postService.getPost(postId);
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, response);
    }

    @GetMapping("/ranking")
    public ApiResponseDto<PostListResponseDTO> getPostList() {
        List<PostResponseDTO> posts = postService.getPostList();
        PostListResponseDTO response = new PostListResponseDTO(posts);
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, response);
    }
}

