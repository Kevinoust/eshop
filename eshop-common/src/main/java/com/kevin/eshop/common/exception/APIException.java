package com.kevin.eshop.common.exception;

import com.kevin.eshop.common.dto.IErrorCode;

public class APIException extends RuntimeException {
    private IErrorCode iErrorCode;

    public APIException(IErrorCode iErrorCode) {
        super(iErrorCode.getMessage());
        this.iErrorCode = iErrorCode;
    }

    public APIException(String message) {
        super(message);
    }

    public APIException(Throwable cause) {
        super(cause);
    }

    public APIException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return iErrorCode;
    }
}
