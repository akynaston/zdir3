package com.trivir.util;

public class IDMUtilsException extends Exception {
    public IDMUtilsException() {
    }

    public IDMUtilsException(String message) {
        super(message);
    }

    public IDMUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

    public IDMUtilsException(Throwable cause) {
        super(cause);
    }

    public IDMUtilsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
