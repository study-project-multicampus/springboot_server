package com.study.study_server.service;

import com.study.study_server.domain.Member;
import com.study.study_server.domain.Study;
import com.study.study_server.exception.ResourceNotFoundException;
import com.study.study_server.repository.StudyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyService {


    private final StudyRepository studyRepository;


    public Study createStudy(Member member,String name, String start){
        Study study = new Study();
        study.setMember(member);
        study.setName(name);
        study.setStart(start);

        studyRepository.save(study);
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

}
