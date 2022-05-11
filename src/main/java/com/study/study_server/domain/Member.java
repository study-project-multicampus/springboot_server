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
    @GeneratedValue
    @Column(name = "member_id")
<<<<<<< HEAD
    private Long id;
=======
    private Long memberId;
>>>>>>> 0ec1f0d045a3c2412bd68f528c046879edd4bb0c

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_email")
    private String email;

    @Column(name = "member_pw")
    private String password;

    @OneToMany(mappedBy = "leader")
    private List<Study> learningStudy = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Study_Join> mystudies = new ArrayList<>();


    public void addStudyJoin(Study_Join study_join){
        this.getMystudies().add(study_join);
        study_join.setMember(this);
    }


}
