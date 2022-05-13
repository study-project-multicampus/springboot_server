package com.study.study_server.controller.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberForm {

    @NotBlank(message = "이름 필드는 비워둘 수 없습니다.")
    private String memberName;

    @NotBlank(message = "비밀번호 필드는 비워둘 수 없습니다.")
    private String memberPw;

    @NotBlank(message = "이메일 필드는 비워둘 수 없습니다.")
    @Email(message = "이메일 형식이 아닙니다.")
    private String memberEmail;
}
