package com.study.study_server.controller;

import com.study.study_server.controller.form.StudyForm;
import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;
import com.study.study_server.repository.MemberRepository;
import com.study.study_server.repository.StudyRepository;
import com.study.study_server.service.StudyService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class StudyController {

    private final StudyRepository studyRepository;
    private final StudyService studyService;
    private final MemberRepository memberRepository;

    @GetMapping("/study/create")
    public String createStudyForm(Model model){
        model.addAttribute("form",new StudyForm());
        return "create_study";
    }

    @PostMapping("/study/create")
    public String studyCreate(StudyForm studyForm, Principal principal){

        Study study = new Study();
        String membername = principal.getName();
        Optional<Member> Member = memberRepository.findByMemberName(membername);
        Member reader = memberRepository.findByMemberId(Member.get().getMemberId());
        study.setStart(studyForm.getStart());
        study.setName(studyForm.getName());
        study.setLeader(reader);
        studyService.enroll(study,Member.get().getMemberId());

        return "redirect:/";


    }
    @GetMapping("/")
    public String studyList(Model model){
        List<Study> studies = studyService.selectAllStudy();
        model.addAttribute("studies",studies);

        return "studylist";

    }


    @PostMapping("/study/{studyId}/join")
    public String join_Study(@PathVariable("studyId")Long studyId,Long memberId){

        studyService.joinStudy(memberId,studyId);

        return "redirect:/";

    }



}
