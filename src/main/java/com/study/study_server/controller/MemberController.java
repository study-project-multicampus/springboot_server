package com.study.study_server.controller;

import com.study.study_server.controller.form.MemberForm;
import com.study.study_server.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping("/signup")
    public String showSignUpForm() {
        return "adduser";
    }

    @PostMapping("/adduser")
    public String addUser (MemberForm memberForm, BindingResult result, Model model){
        return null;
    }

}
