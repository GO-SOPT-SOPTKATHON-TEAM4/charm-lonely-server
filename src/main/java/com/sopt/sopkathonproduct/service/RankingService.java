package com.sopt.sopkathonproduct.service;

import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingService {

    private final PostRepository postRepository;

    public void updateRanking(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new EntityNotFoundException("해당 게시글이 존재하지 않습니다."));
        post.updatePoint();
    }
}
