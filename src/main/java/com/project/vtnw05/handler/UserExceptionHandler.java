package com.project.vtnw05.handler;

import java.util.Collections;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.vtnw05.DTO.APIResponse;
import com.project.vtnw05.DTO.ErrorDTO;
import com.project.vtnw05.exception.UserException;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserException.class)
    public APIResponse <?> handleServiceException(UserException exception) {
        APIResponse <?> serviceResponse = new APIResponse<>();
        serviceResponse.setStatus("FAILED");
        serviceResponse.setErrors(
            Collections.singletonList(new ErrorDTO("username and password are wrong", exception.getMessage()))
        );
        return serviceResponse;
    }

}
