package com.study.study_server.controller;

import com.study.study_server.controller.form.MemberForm;
import com.study.study_server.domain.Member;
import com.study.study_server.service.MemberService;
import com.study.study_server.service.StudyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final StudyService studyService;

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser (MemberForm memberForm, BindingResult result, Model model){
        if(result.hasErrors()){
            return "adduser";
        }

        Member member = new Member();
        BeanUtils.copyProperties(memberForm, member);
        memberService.save(member);

//        model.addAttribute("study", studyService.selectAllStudy());
        return "studylist";
    }

}
