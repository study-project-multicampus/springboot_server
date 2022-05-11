package com.study.study_server.repository;

import com.study.study_server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // 회원 생성
    Member save(Member member);

    // memberName 으로 회원 검색
    Optional<Member> findByMemberName(String memberName);



}
