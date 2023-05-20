package com.sopt.sopkathonproduct.controller;


import com.sopt.sopkathonproduct.common.dto.ApiResponseDto;
import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.request.UploadRequestDTO;
import com.sopt.sopkathonproduct.dto.response.PostResponseDto;
import com.sopt.sopkathonproduct.dto.response.UploadResponseDTO;
import com.sopt.sopkathonproduct.exception.SuccessStatus;
import com.sopt.sopkathonproduct.service.PostService;
import com.sopt.sopkathonproduct.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final S3Service s3Service;

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

    @GetMapping("/{postId}")
    public ApiResponseDto getPost(@PathVariable Long postId) {
        Post response = postService.getById(postId);
        return ApiResponseDto.success(SuccessStatus.READ_POST_SUCCESS, PostResponseDto.of(response.getId(), response.getNickname(), response.getImageUrl(), response.getComment()));
    }

}