package com.study.study_server.repository;

import com.study.study_server.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface StudyRepository extends JpaRepository<Study,Long> {
    Optional<Study> findById(Long id);


}
