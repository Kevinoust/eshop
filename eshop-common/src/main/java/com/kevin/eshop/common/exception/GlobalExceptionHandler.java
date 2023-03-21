package com.kevin.eshop.common.exception;

import com.kevin.eshop.common.dto.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(APIException.class)
    public CommonResponse<?> handleAPIException(APIException ex) {
        if(ex.getErrorCode() != null) {
            return CommonResponse.failed(ex.getErrorCode());
        }
        return CommonResponse.failed(ex.getMessage());
    }
}
