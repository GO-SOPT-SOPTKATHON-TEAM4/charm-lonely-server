package com.sopt.sopkathonproduct.controller;


import com.sopt.sopkathonproduct.common.dto.ApiResponseDto;
import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.request.UploadRequestDTO;
import com.sopt.sopkathonproduct.dto.response.PostListResponseDTO;
import com.sopt.sopkathonproduct.dto.response.PostResponseDTO;
import com.sopt.sopkathonproduct.dto.response.RandomPostResponseDTO;
import com.sopt.sopkathonproduct.dto.response.UploadResponseDTO;
import com.sopt.sopkathonproduct.exception.SuccessStatus;
import com.sopt.sopkathonproduct.service.PostService;
import com.sopt.sopkathonproduct.service.RankingService;
import com.sopt.sopkathonproduct.service.S3Service;
import lombok.Data;
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
    public ApiResponseDto<PostsDTO> getRandomImage() {
        List<RandomPostResponseDTO> dtoList = postService.getRandom8Post();
        PostsDTO postsDTO = new PostsDTO(dtoList);
        return ApiResponseDto.success(SuccessStatus.READ_POST_LIST_SUCCESS, postsDTO);
    }

    @Data
    public static class PostsDTO {
        List<RandomPostResponseDTO> posts;

        public PostsDTO(List<RandomPostResponseDTO> posts) {
            this.posts = posts;
        }
    }

    @GetMapping("/{postId}")
    public ApiResponseDto getPost(@PathVariable Long postId) {
        Post response = postService.getById(postId);
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, PostResponseDTO.of(response));
    }

    @GetMapping("/ranking")
    public ApiResponseDto getPostList() {
        List<Post> response = postService.getAll();
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, PostListResponseDTO.of(response));
    }
}

