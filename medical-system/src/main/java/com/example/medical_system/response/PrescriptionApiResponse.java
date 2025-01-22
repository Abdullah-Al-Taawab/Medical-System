package com.example.medical_system.response;

import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
public class PrescriptionApiResponse {

    private int id;

    private String Message;

    public PrescriptionApiResponse()
    {

    }

    public PrescriptionApiResponse(int id, String message) {
        this.id = id;
        Message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
