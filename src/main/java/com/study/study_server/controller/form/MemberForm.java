package com.study.study_server.controller.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberForm {
    private String memberName;
    private String memberPw;
    private String memberEmail;
}
