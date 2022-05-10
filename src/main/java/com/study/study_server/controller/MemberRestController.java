package com.study.study_server.controller;

import com.study.study_server.domain.Member;
import com.study.study_server.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {
    private MemberService memberService;

    public MemberRestController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public Member addMember(@RequestBody Member member){
        return memberService.insertMember(member);
    }

    @GetMapping
    public Member getMember(@PathVariable String memberName){
        return memberService.selectMemeber(memberName);
    }

}
