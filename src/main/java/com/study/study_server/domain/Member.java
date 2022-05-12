package com.study.study_server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_email")
    private String memberEmail;

    @OneToMany(mappedBy = "leader")
    private List<Study> learningStudy = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Study_Join> mystudies = new ArrayList<>();

    public Member() {

    }

    public void addStudyJoin(Study_Join study_join){
        this.getMystudies().add(study_join);
        study_join.setMember(this);
    }

    public Member(String memberName, String memberEmail, String memberPw) {
        this.memberName = memberName;
        this.memberPw = memberPw;
        this.memberEmail = memberEmail;
    }


}
