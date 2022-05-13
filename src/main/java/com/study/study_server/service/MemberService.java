package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.exception.ResourceNotFoundException;
import com.study.study_server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
    MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Member save(Member member){
        return memberRepository.save(member);
    }
//    public Member insertMember(Member member){
//        return memberRepository.save(member);
//    }

    @Transactional(readOnly = true)
    public Member selectMemeber(String memberName){
        Optional<Member> optionalMember = memberRepository.findByMemberName(memberName);
        Member existMember = optionalMember.orElseThrow(() -> new ResourceNotFoundException("Member", "memberName", memberName));
        return existMember;
    }

    @Override
    public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
        Optional<Member> byUsername = memberRepository.findByMemberName(memberName);
        Member member = byUsername.orElseThrow(() -> new UsernameNotFoundException(memberName));
        return new User(member.getMemberName(),
                member.getMemberPw(), authorities());
    }
    //User 객체의 세번째 인자 USER라는 ROLE을 가진 사용자이다 라고 설정하는 부분
    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }



}
