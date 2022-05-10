package com.study.study_server.config;

import com.study.study_server.domain.Member;
import com.study.study_server.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String memberName = authentication.getName();
        String memberPw = authentication.getCredentials().toString();

        Member member = memberRepository.findByMemberName(memberName).orElseThrow(() -> new UsernameNotFoundException(memberName));

        if(passwordEncoder.matches(member.getMemberPw(), memberPw)) {
            throw new BadCredentialsException("UnAuthorized");
        }

        return new UsernamePasswordAuthenticationToken(memberName, memberPw);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
