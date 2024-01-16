package com.master.springbootmasterclass.exception;

import com.master.springbootmasterclass.response.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AppExceptionHanddler {
    @ExceptionHandler(AppException.class)
    public ResponseEntity<Response>handleAppException(AppException appException)
    {
        return Response.getResponseData(false, appException.getMessage(), null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Response> handleRuntimeException(RuntimeException runtimeException){
        return Response.getResponseData(false,"Something went wrong! Please try again later." ,runtimeException.getMessage());
    }

}
