package com.study.study_server.repository;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;

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


    @Test
    @Transactional
    @Rollback(value = false)
    public void 스터디가입(){

        //리더멤버 생성
        Member member = new Member();
        member.setMemberName("kim");
        member.setMemberEmail("tt@naver.com");
        memberService.save(member);
        //스터디 생성
        Study algorithm = new Study();
        algorithm.setName("알고리즘");
        algorithm.setStart("2022-02-01");




        //등록
        Long enroll_id = studyService.enroll(algorithm, member.getMemberId());


        //스터디 가입 해보기
        Member member2 = new Member();
        member2.setMemberName("yang");
        member2.setMemberEmail("tt@maver.com");
        memberService.save(member2);

        studyService.joinStudy(member2.getMemberId(), enroll_id);

        Member member3 = new Member();
        member3.setMemberName("kang");
        member3.setMemberEmail("tt@daum.net");
        memberService.save(member3);

        studyService.joinStudy(member3.getMemberId(), enroll_id);




        //두번째 스터디 만들기
        Study java = new Study();
        java.setName("자바스터디");
        java.setStart("2022-01-01");

        //두번째 스터디 리더 만들기
        Member reader = new Member();
        reader.setMemberName("shin");
        reader.setMemberEmail("tt.@aver.com");
        memberService.save(reader);

        Long enroll_id2 = studyService.enroll(java, reader.getMemberId());


        //두번째 스터디 참가원

        Member member4 = new Member();
        member4.setMemberName("hong");
        member4.setMemberEmail("hong@naver.com");
        memberService.save(member4);

        studyService.joinStudy(member4.getMemberId(),enroll_id2 );






    }
}