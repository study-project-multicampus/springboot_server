package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Role;
import com.study.study_server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String memberName) throws UsernameNotFoundException {
        Member member = memberRepository.findByMemberName(memberName)
                .orElseThrow(() -> new UsernameNotFoundException(memberName));
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
//        if (memberName.equals("sup2is@gmail.com")) {
//            grantedAuthorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        }

        return new User(member.getMemberName(), member.getMemberPw(), grantedAuthorities);
    }

    public Member authenticateByNameAndPassword(String memberName, String memberPw) {
        Member member = memberRepository.findByMemberName(memberName)
                .orElseThrow(() -> new UsernameNotFoundException(memberName));

        if (!passwordEncoder.matches(memberPw, member.getMemberPw())) {
            throw new BadCredentialsException("Password not matched");
        }

        return member;
    }
}

