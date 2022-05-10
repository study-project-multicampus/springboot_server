package com.study.study_server.repository;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;

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
    StudyService studyService;


    @Test
    @Transactional
    @Rollback(value = false)
    public void 스터디_생성(){
        Member member = new Member();
        member.setName("kim");
        member.setEmail("tt@nav.com");

        Study algorithm = studyService.createStudy(member, "알고리즘스터디", "2020-02-01");
        Study java = studyService.createStudy(member, "자바알고리즘", "2021-02-01");

        studyRepository.save(algorithm);
        studyRepository.save(java);

    }



}