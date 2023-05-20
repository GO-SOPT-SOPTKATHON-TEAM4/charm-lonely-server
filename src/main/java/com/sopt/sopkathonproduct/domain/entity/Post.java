package com.sopt.sopkathonproduct.domain.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.*;

@Entity
@NoArgsConstructor(access = PROTECTED)
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nickname;

    private String imageUrl;

    private String comment;

    private Long point;

    @Builder
    public Post(String nickname, String imageUrl, String comment, Long point) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.comment = comment;
        this.point = point;
    }

    public void updatePoint() {
        this.point += 1L;
    }
}
