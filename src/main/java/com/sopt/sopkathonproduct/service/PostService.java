package com.sopt.sopkathonproduct.service;


import com.sopt.sopkathonproduct.domain.entity.Post;
import com.sopt.sopkathonproduct.dto.response.RandomPostResponseDTO;
import com.sopt.sopkathonproduct.exception.ErrorStatus;
import com.sopt.sopkathonproduct.exception.NotFoundException;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository postRepository;


    public List<RandomPostResponseDTO> getRandom8Post() {
        long qty = postRepository.count();
        int totalPostsToFetch = 8;

        List<Long> randomIds = new ArrayList<>();

        if (qty < totalPostsToFetch) {
            throw new RuntimeException("게시글이 8개 미만입니다.");
        }

        List<RandomPostResponseDTO> postResponseDTOList = new ArrayList<>();
        Random rand = new Random();

        while (randomIds.size() < totalPostsToFetch) {
            long randomId = rand.nextInt((int) qty) + 1;
            if (!randomIds.contains(randomId)) {
                randomIds.add(randomId);
            }
        }

        for (long idx : randomIds) {
            Post post = postRepository.findById(idx)
                    .orElseThrow(() -> new EntityNotFoundException("해당 게시글이 존재하지 않습니다."));
            postResponseDTOList.add(
                    RandomPostResponseDTO.builder()
                            .postId(post.getId())
                            .nickname(post.getNickname())
                            .imageUrl(post.getImageUrl())
                            .comment(post.getComment())
                            .build());
        }
        return postResponseDTOList;

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
