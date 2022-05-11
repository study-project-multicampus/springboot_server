package com.study.study_server.controller;

import com.study.study_server.domain.Member;
import com.study.study_server.repository.MemberRepository;
import com.study.study_server.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false)
    void 회원생성(){
        Member member = new Member();
        member.setMemberName("test");
        member.setMemberPw("ddd");
        member.setMemberEmail("aa@aa.com");
        memberService.insertMember(member);

        Member member1 = memberRepository.findByMemberName(member.getMemberName()).orElseThrow(() -> new IllegalArgumentException("no data"));

        assertEquals(member.getMemberId(), member1.getMemberId());
    }
}