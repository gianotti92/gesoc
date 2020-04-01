package com.gestiondatos.exception;

public enum GesocExceptionCode {
    CLOSE_COMERCIAL_OPERATION_EGRESS_CLOSE("the comercial operation egress is closed"),
    CLOSE_COMERCIAL_OPERATION_ENTRY_WITH_SERVICE("the comercial operation entry contains servicies");

    private final String message;

    GesocExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
