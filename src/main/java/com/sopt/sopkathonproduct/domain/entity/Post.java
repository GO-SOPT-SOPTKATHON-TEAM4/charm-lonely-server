package com.sopt.sopkathonproduct.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

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

    @Column(columnDefinition = "bigint default '0'")
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

    public static Post createPost(String nickname, String imageUrl, String comment) {
        Post post = Post.builder()
                .nickname(nickname)
                .imageUrl(imageUrl)
                .comment(comment)
                .build();
        post.updateDefaultPoint();
        return post;
    }

    public void updatePoint() {
        this.point += 1L;
    }

    public void updateDefaultPoint() {
        this.point = 0L;
    }
}
