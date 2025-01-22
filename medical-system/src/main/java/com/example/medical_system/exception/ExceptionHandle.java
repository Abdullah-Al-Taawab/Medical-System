package com.example.medical_system.exception;

import com.example.medical_system.response.PrescriptionApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler
    public ResponseEntity<PrescriptionApiExceptionResponse> excep(PrescriptionApiException ex)
    {
        PrescriptionApiExceptionResponse e=new PrescriptionApiExceptionResponse();

        e.setMessage(ex.getMessage());
        e.setStatus(HttpStatus.NOT_IMPLEMENTED.value());

        return new ResponseEntity<>(e, HttpStatus.NOT_IMPLEMENTED);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<PrescriptionApiExceptionResponse> handleValidationException(MethodArgumentNotValidException ex) {
        PrescriptionApiExceptionResponse e = new PrescriptionApiExceptionResponse();
        e.setMessage("Validation failed: " + ex.getBindingResult().getFieldError().getDefaultMessage());
        e.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
