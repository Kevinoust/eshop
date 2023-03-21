package com.kevin.eshop.common.dto;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Success"),
    NOT_AUTHENTICATED(401, "Authenticated"),
    NO_PERMISSION(403, "Permission denied"),
    VALIDATION_FAILED(404, "Validation failed"),
    FAILED(500, "Failed");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
