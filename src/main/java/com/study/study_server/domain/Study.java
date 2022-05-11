package com.study.study_server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Study {
    @Id
    @GeneratedValue
    @Column(name = "study_id")
    private Long id;

    @Column(name = "study_name")
    private String name;

    @Column(name = "study_start")
    private String start;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "leader_id")
   private Member leader;

   @OneToMany(mappedBy = "study",cascade = CascadeType.ALL)
    private List<Study_Join> study_joins = new ArrayList<>();

   public void addStudyJoin(Study_Join study_join){
       study_joins.add(study_join);
       study_join.setStudy(this);
   }
   public void leaderMember(Member member){
       leader = member;
       member.getLearningStudy().add(this);
   }





}
