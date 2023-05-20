package com.sopt.sopkathonproduct.service;

import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RankingService {

    private final PostRepository postRepository;
}
