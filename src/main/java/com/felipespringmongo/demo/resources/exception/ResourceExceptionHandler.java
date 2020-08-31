package com.felipespringmongo.demo.resources.exception;


import com.felipespringmongo.demo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
       StandardError error = new StandardError(System.currentTimeMillis(),status.value(),"não encontrado", e.getMessage(), request.getRequestURI());
       return  ResponseEntity.status(status).body(error);
    }

}
