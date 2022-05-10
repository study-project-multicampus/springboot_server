package com.study.study_server.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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


}
