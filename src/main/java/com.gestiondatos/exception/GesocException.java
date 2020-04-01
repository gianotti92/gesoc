package com.gestiondatos.exception;

public class GesocException extends RuntimeException {
    private final GesocExceptionCode gesocExceptionCode;

    public GesocException(GesocExceptionCode gesocExceptionCode) {
        this.gesocExceptionCode = gesocExceptionCode;
    }

    public GesocException(String message, GesocExceptionCode gesocExceptionCode) {
        super(message);
        this.gesocExceptionCode = gesocExceptionCode;
    }

    public GesocException(String message, Throwable cause, GesocExceptionCode gesocExceptionCode) {
        super(message, cause);
        this.gesocExceptionCode = gesocExceptionCode;
    }

    public GesocException(Throwable cause, GesocExceptionCode gesocExceptionCode) {
        super(cause);
        this.gesocExceptionCode = gesocExceptionCode;
    }

    public GesocException(String message,
                          Throwable cause,
                          boolean enableSuppression,
                          boolean writableStackTrace,
                          GesocExceptionCode gesocExceptionCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.gesocExceptionCode = gesocExceptionCode;
    }
}
