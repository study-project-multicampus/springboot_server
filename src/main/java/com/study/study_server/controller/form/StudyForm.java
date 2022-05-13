package com.study.study_server.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class StudyForm {
    private Long id;

    @NotBlank(message = "이름 필드는 비워둘 수 없습니다.")
    private String name;

    @NotBlank
    private String start;
}
