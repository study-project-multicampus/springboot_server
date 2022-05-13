package com.study.study_server.exception;

public class MemberNotExistException extends RuntimeException{

    private String memberName;

    public MemberNotExistException(String memberName){
        super(String.format("%s not found",memberName));
        this.memberName = memberName;
    }
}
