package com.sopt.sopkathonproduct.service;

import com.sopt.sopkathonproduct.common.util.S3Util;
import com.sopt.sopkathonproduct.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class S3Service {

    private final S3Util s3Util;

    private final PostRepository postRepository;

}
