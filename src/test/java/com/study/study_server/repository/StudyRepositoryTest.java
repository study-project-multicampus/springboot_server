package com.study.study_server.repository;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;

import com.study.study_server.domain.Study_Join;
import com.study.study_server.service.MemberService;
import com.study.study_server.service.StudyService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudyRepositoryTest {

    @Autowired
    StudyRepository studyRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    StudyService studyService;


//    @Test
//    @Transactional
//    @Rollback(value = false)
//    public void 스터디_생성(){
//        Member member = new Member();
//        member.setName("kim");
//        member.setEmail("tt@nav.com");
//
//        Study algorithm = studyService.createStudy(member, "알고리즘스터디", "2020-02-01");
//        Study java = studyService.createStudy(member, "자바알고리즘", "2021-02-01");
//
//        studyRepository.save(algorithm);
//        studyRepository.save(java);
//
//    }

    @Test
    @Transactional
    @Rollback(value = false)
    public void 스터디가입(){

        //리더멤버 생성
        Member member = new Member();
        member.setName("kim");
        member.setEmail("tt@naver.com");
        memberService.save(member);
        //스터디 생성
        Study algorithm = new Study();
        algorithm.setName("알고리즘");
        algorithm.setStart("2022-02-01");




        //등록
        Long enroll_id = studyService.enroll(algorithm, member.getId());


        //스터디 가입 해보기
        Member member2 = new Member();
        member2.setName("yang");
        member2.setEmail("tt@maver.com");
        memberService.save(member2);

         studyService.joinStudy(member2.getId(), enroll_id);

        Member member3 = new Member();
        member3.setName("kang");
        member3.setEmail("tt@daum.net");
        memberService.save(member3);

        studyService.joinStudy(member3.getId(), enroll_id);






    }



}