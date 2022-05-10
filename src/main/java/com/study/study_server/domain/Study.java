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

   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
   @JoinColumn(name = "member_id")
   private Member member;






}
