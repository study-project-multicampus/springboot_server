package com.study.study_server.controller;

import com.study.study_server.domain.Member;
import com.study.study_server.repository.MemberRepository;
import com.study.study_server.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberControllerTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 회원생성(){
        Member member = new Member();
        member.setMemberName("test");
        memberService.insertMember(member);

        Member member1 = memberRepository.findByMemberName(member.getMemberName()).orElseThrow(() -> new IllegalArgumentException("no data"));

        assertEquals(member.getMemberNo(), member1.getMemberNo());
    }
}