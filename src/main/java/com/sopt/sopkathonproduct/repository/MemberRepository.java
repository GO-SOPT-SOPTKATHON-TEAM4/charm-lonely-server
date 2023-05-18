package com.sopt.sopkathonproduct.repository;

import com.sopt.sopkathonproduct.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
