package com.sopt.sopkathonproduct.repository;

import com.sopt.sopkathonproduct.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByPointDesc();
}
