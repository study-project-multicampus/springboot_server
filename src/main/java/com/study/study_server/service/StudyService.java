package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;
import com.study.study_server.domain.Study_Join;
import com.study.study_server.exception.MemberNotExistException;
import com.study.study_server.exception.ResourceNotFoundException;
import com.study.study_server.exception.StudyNotExistException;
import com.study.study_server.repository.MemberRepository;
import com.study.study_server.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyService {


    private final StudyRepository studyRepository;
    private final MemberRepository memberRepository;


    @Transactional
    public Long enroll(Study study,Long reader_id){
        Member member = memberRepository.findByMemberId(reader_id);
        study.leaderMember(member);

        Study_Join.createStudyJoin(study, member);

        studyRepository.save(study);

        return study.getId();

    }

    @Transactional
    public Study joinStudy(Long member_id,Long study_id){
        Member member = memberRepository.findByMemberId(member_id);
        validateDulicateMember(member,study_id);
        Study study= studyRepository.findById(study_id).orElseThrow(()->new StudyNotExistException(study_id));

        Study_Join studyJoin = Study_Join.createStudyJoin(study, member);
        study.addStudyJoin(studyJoin);

        return study;

    }

    @Transactional(readOnly = true)
    public List<Study> selectAllStudy(){ return studyRepository.findAll();}

    @Transactional(readOnly = true)
    public Study selectStudy(Long id){
        Optional<Study> optionalStudy = studyRepository.findById(id);
        Study existStudy = optionalStudy.orElseThrow(() -> new ResourceNotFoundException("Study", "id", id));
        return  existStudy;

    }

    private void validateDulicateMember(Member member,Long study_id){
        Study study= studyRepository.findById(study_id).orElseThrow(()-> new StudyNotExistException(study_id));
        List<Study_Join> study_joins = study.getStudy_joins();
        System.out.println("study_joins = " + study_joins.toString());
        System.out.println("member.getMemberName() = " + member.getMemberName());
        
        for(Study_Join study_join : study_joins){
            if(Objects.equals(member.getMemberName(), study_join.getMember().getMemberName())){
                throw new IllegalStateException("이미 존재하는 회원입니다");
            }
        }
    }

}
