package com.example.medical_system.exception;

public class PrescriptionApiExceptionResponse {


    private Integer status;
    private String message;

    public PrescriptionApiExceptionResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public PrescriptionApiExceptionResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
