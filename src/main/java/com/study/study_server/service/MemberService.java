package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Member save(Member member){
        return memberRepository.save(member);
    }


}
