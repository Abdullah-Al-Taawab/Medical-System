package com.example.medical_system.exception;

public class PrescriptionApiException extends RuntimeException{

    public PrescriptionApiException() {
    }

    public PrescriptionApiException(String message) {
        super(message);
    }

    public PrescriptionApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrescriptionApiException(Throwable cause) {
        super(cause);
    }
}
