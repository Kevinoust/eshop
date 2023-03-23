package com.kevin.eshop.common.exception;

import com.kevin.eshop.common.dto.IErrorCode;

public class Asserts {
    public static void fail(String message) {
        throw new APIException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new APIException(errorCode);
    }

    public static APIException exceptionSupplier(IErrorCode errorCode) {
        return new APIException(errorCode);
    }
}
