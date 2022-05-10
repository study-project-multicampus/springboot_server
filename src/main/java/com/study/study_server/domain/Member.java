package com.study.study_server.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_no")
    private int memberNo;

    @Column(name = "member_name")
    private String memberName;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_email")
    private String memberEmail;

    public Member(int memberNo, String memberName, String memberEmail, String memberPw) {
        this.memberNo = memberNo;
        this.memberName = memberName;
        this.memberPw = memberEmail;
        this.memberEmail = memberEmail;
    }
}
