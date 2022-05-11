package com.study.study_server.repository;

import com.study.study_server.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Id> {
    Member findById(Long id);
}
