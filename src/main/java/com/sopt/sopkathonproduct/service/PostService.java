package com.sopt.sopkathonproduct.service;


import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.exception.ErrorStatus;
import com.sopt.sopkathonproduct.exception.NotFoundException;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;

    // TODO 2zerozu 추후 구현 예정
/*    public List<Post> getAll() {

    }*/

    public Post getById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException(ErrorStatus.NOT_FOUND_EXCEPTION));

        return Post.newInstance(
                post.getId(),
                post.getNickname(),
                post.getImageUrl(),
                post.getComment()
        );
    }
}
