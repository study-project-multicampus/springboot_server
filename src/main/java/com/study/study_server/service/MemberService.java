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
    private MemberRepository memberRepository;

    public Member insertMember(Member member){
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        memberRepository.findByMemberName(member.getMemberName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Transactional(readOnly = true)
    public Member selectMemeber(String memberName){
        Optional<Member> optionalMember = memberRepository.findByMemberName(memberName);
        Member existMember = optionalMember.orElseThrow(() -> new ResourceNotFoundException("Member", "memberName", memberName));
        return existMember;
    }


}
