package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.exception.ResourceNotFoundException;
import com.study.study_server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Member save(Member member){
        return memberRepository.save(member);
    }
    public Member insertMember(Member member){
        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Member selectMemeber(String memberName){
        Optional<Member> optionalMember = memberRepository.findByMemberName(memberName);
        Member existMember = optionalMember.orElseThrow(() -> new ResourceNotFoundException("Member", "memberName", memberName));
        return existMember;
    }



}
