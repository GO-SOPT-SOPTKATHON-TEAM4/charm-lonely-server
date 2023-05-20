package com.sopt.sopkathonproduct.dto.response;

import com.sopt.sopkathonproduct.domain.entity.Post;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseDto {

    private Long id;
    private String nickname;
    private String imageUrl;
    private String comment;

    public static PostResponseDto of(Long id, String nickname, String imageUrl, String comment) {
        return new PostResponseDto(id, nickname, imageUrl, comment);
    }
}
