package com.skillshiring.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobelExeptions {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userEceptionHandler(UserException ue, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> otherEceptionHandler(Exception ue, WebRequest req){
        ErrorDetails errorDetails = new ErrorDetails(ue.getMessage(),req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
