package com.sopt.sopkathonproduct.domain.entity;

import com.sopt.sopkathonproduct.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
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

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false, columnDefinition = "bigint default 0")
    private Long point;

    @Builder
    public Post(String nickname, String imageUrl, String comment) {
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.comment = comment;
    }

    @Builder
    public Post(Long id, String nickname, String imageUrl, String comment) {
        this.id = id;
        this.nickname = nickname;
        this.imageUrl = imageUrl;
        this.comment = comment;
    }

    public static Post newInstance(Long id, String nickname, String imageUrl, String comment) {
        return new Post(id, nickname, imageUrl, comment);
    }

    public void updatePoint() {
        this.point += 1L;
    }
}
