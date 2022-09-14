package com.rewards.rewardpoints.controller;

import com.rewards.rewardpoints.exception.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RewardsExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex){
        return new ResponseEntity((new ErrorMessage(HttpStatus.UNPROCESSABLE_ENTITY.toString(),"Please provide numeric value")), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> handleAnyError(Exception ex){
        return new ResponseEntity((new ErrorMessage(HttpStatus.UNSUPPORTED_MEDIA_TYPE.toString(),"Unable to process your request at this time")), HttpStatus.BAD_REQUEST);
    }
}
