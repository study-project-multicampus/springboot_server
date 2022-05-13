package com.study.study_server.controller.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberForm {

    @NotBlank
    private String memberName;

    @NotBlank
    private String memberPw;

    @NotBlank
    private String memberEmail;
}
