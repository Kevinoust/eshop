package com.kevin.eshop.common.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class CommonResponse<T> {
    private long statusCode;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResponse<T> success(T data, String message) {
        return new CommonResponse<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    public static <T> CommonResponse<T> failed(IErrorCode iErrorCode) {
        return new CommonResponse<>(iErrorCode.getCode(), iErrorCode.getMessage(), null);
    }

    public static <T> CommonResponse<T> failed(IErrorCode iErrorCode, String message) {
        return new CommonResponse<>(iErrorCode.getCode(), message, null);
    }

    public static <T> CommonResponse<T> failed(String message) {
        return new CommonResponse<>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> CommonResponse<T> failed() {
        return new CommonResponse<>(ResultCode.FAILED.getCode(), ResultCode.FAILED.getMessage(), null);
    }

    public static <T> CommonResponse<T> validationFailed() {
        return failed(ResultCode.VALIDATION_FAILED);
    }

    public static <T> CommonResponse<T> validationFailed(String message) {
        return failed(ResultCode.VALIDATION_FAILED, message);
    }

    public static <T> CommonResponse<T> notAuthenticated() {
        return failed(ResultCode.NOT_AUTHENTICATED);
    }

    public static <T> CommonResponse<T> noPermission() {
        return failed(ResultCode.NO_PERMISSION);
    }

    public static <T> CommonResponse<T> badRequest() {
        return failed(ResultCode.BAD_REQUEST);
    }

    public static <T> CommonResponse<T> badRequest(String message) {
        return failed(ResultCode.BAD_REQUEST, message);
    }
}
