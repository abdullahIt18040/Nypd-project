package com.master.springbootmasterclass.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestControllerAdvice
@ResponseStatus
public class RestResponeEntityHandlerHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(EmployeeNotFoundException.class)
    public ErrorMesage deptNotFoundExcepton(EmployeeNotFoundException exception, WebRequest webRequest)
    {
          ErrorMesage mesage= new ErrorMesage(HttpStatus.NOT_FOUND,exception.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mesage).getBody();

    }


}
