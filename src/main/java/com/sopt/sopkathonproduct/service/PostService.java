package com.sopt.sopkathonproduct.service;


import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.response.PostResponseDTO;
import com.sopt.sopkathonproduct.exception.ErrorStatus;
import com.sopt.sopkathonproduct.exception.NotFoundException;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public List<PostResponseDTO> getPostList() {
        List<Post> posts = postRepository.findAllByOrderByPointDesc();
        return posts.stream().map(this::fromPost).collect(Collectors.toList());
    }

    public PostResponseDTO getPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION));

        return fromPost(post);
    }

    private PostResponseDTO fromPost(Post post) {
        return PostResponseDTO.builder()
                .postId(post.getId())
                .nickname(post.getNickname())
                .imageUrl(post.getImageUrl())
                .comment(post.getComment())
                .build();
    }

    public List<PostResponseDTO> getRandom8Post() {
        long qty = postRepository.count();
        int totalPostsToFetch = 8;

        List<Long> randomIds = new ArrayList<>();

        if (qty < totalPostsToFetch) {
            throw new RuntimeException("게시글이 8개 미만입니다.");
        }

        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();
        Random rand = new Random();

        while (randomIds.size() < totalPostsToFetch) {
            long randomId = rand.nextInt((int) qty) + 1;
            if (!randomIds.contains(randomId)) {
                randomIds.add(randomId);
            }
        }

        for (long idx : randomIds) {
            Post post = postRepository.findById(idx)
                    .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION));
            postResponseDTOList.add(fromPost(post));
        }
        return postResponseDTOList;
    }
}
