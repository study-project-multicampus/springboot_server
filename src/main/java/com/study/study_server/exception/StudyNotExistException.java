package com.study.study_server.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudyNotExistException extends RuntimeException{

    private final Long study_id;

    public StudyNotExistException(Long study_id){
        super(String.format("%o nor found",study_id));
        this.study_id =study_id;
    }

}
