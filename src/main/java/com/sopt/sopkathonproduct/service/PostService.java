package com.sopt.sopkathonproduct.service;


import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.exception.ErrorStatus;
import com.sopt.sopkathonproduct.exception.NotFoundException;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::fromPost).collect(Collectors.toList());
    }

    public Post getById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION));

        return fromPost(post);
    }

    private Post fromPost(Post post) {
        return Post.newInstance(post.getId(), post.getNickname(), post.getImageUrl(), post.getComment());
    }
}
