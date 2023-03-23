package com.kevin.eshop.common.dto;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad request"),
    VALIDATION_FAILED(400, "Validation failed"),
    USER_ALREADY_EXISTED(400, "User already existed!"),
    NOT_AUTHENTICATED(401, "Not authenticated"),
    AUTH_CODE_NOT_VALID(401, "Authentication code is not valid"),
    NO_PERMISSION(403, "Permission denied"),
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
