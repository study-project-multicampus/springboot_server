package com.study.study_server.controller;

import com.study.study_server.controller.form.MemberForm;
import com.study.study_server.domain.Member;
import com.study.study_server.service.MemberService;
import com.study.study_server.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final StudyService studyService;

    @GetMapping("/signup")
    public String showSignUpForm(MemberForm memberForm) {
        return "add_user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid MemberForm memberForm, BindingResult result) {
        if (result.hasErrors()) {
            return "add_user";
        }

        Member member = new Member();
        BeanUtils.copyProperties(memberForm, member);
        memberService.save(member);

//        model.addAttribute("study", studyService.selectAllStudy());
        return "studylist";
    }

    @GetMapping()
    public Member selectMemeber(String memberName) {
        return memberService.selectMemeber(memberName);
    }

}
