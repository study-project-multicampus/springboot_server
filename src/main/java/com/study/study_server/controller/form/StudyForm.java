package com.study.study_server.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class StudyForm {
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String start;
}
