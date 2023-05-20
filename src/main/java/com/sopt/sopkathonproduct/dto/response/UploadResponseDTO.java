package com.sopt.sopkathonproduct.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
public class UploadResponseDTO {
    private Long postId;

    @Builder
    public UploadResponseDTO(Long postId) {
        this.postId = postId;
    }
}
