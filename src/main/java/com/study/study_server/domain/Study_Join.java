package com.study.study_server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Study_Join {

    @Id
    @GeneratedValue
    @Column(name = "study_join_id")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id")
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "study_id")
    private Study study;

    public static Study_Join createStudyJoin(Study study, Member member){
        Study_Join study_join = new Study_Join();
        study_join.setStudy(study);
        study_join.setMember(member);


        study.getStudy_joins().add(study_join);
        member.getMystudies().add(study_join);

        return study_join;
    }






}
