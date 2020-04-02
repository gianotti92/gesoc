package com.gestiondatos.exception;

public class GesocException extends RuntimeException {
    private final GesocExceptionCode gesocExceptionCode;

    public GesocException(GesocExceptionCode gesocExceptionCode) {
        this.gesocExceptionCode = gesocExceptionCode;
    }

    public GesocExceptionCode getGesocExceptionCode() {
        return gesocExceptionCode;
    }
}
