package com.study.study_server.repository;

import com.study.study_server.domain.Study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudyRepositoryTest {

    @Autowired
    StudyRepository studyRepository;


    @Test
    @Rollback(value = false)
    public void 연습용테스트() {

        Study study = new Study();
        study.setName("알고리즘스터디");
        study.setStart("2022-02");

        Study newStudy = studyRepository.save(study);

        Optional<Study> byName = studyRepository.findByName(study.getName());

        System.out.println(newStudy.getName());

        Assertions.assertThat(byName).isNotEmpty();


    }

}