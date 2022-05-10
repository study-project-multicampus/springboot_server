package com.study.study_server.controller;

import com.study.study_server.domain.Study;
import com.study.study_server.repository.StudyRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Getter @Setter
@RequiredArgsConstructor
public class StudyController {

    private final StudyRepository studyRepository;

//    @PostMapping("/study/create")
//    public Study studyCreate()
}
