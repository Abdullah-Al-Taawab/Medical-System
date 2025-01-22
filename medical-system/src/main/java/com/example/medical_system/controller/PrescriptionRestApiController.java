package com.example.medical_system.controller;


import com.example.medical_system.entity.Prescription;
import com.example.medical_system.exception.PrescriptionApiException;
import com.example.medical_system.exception.PrescriptionApiExceptionResponse;
import com.example.medical_system.request.PrescriptionApiRequest;
import com.example.medical_system.response.PrescriptionApiResponse;
import com.example.medical_system.service.PrescriptionServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API/v1")

public class PrescriptionRestApiController {

    private PrescriptionServiceImp prescriptionServiceImp;

    @Autowired
    public PrescriptionRestApiController(PrescriptionServiceImp prescriptionServiceImp) {
        this.prescriptionServiceImp = prescriptionServiceImp;
    }


    @PostMapping("/prescription/add")
    public ResponseEntity<?> add(@Valid @RequestBody PrescriptionApiRequest prescriptionApiRequest) {
        try {

            PrescriptionApiResponse response = new PrescriptionApiResponse();

            Prescription prescription = new Prescription();

            prescription.setPrescriptionDate(prescriptionApiRequest.getPrescriptionDate());
            prescription.setPatientName(prescriptionApiRequest.getPatientName());
            prescription.setPatientAge(prescriptionApiRequest.getPatientAge());
            prescription.setPatientgender(prescriptionApiRequest.getPatientgender());
            prescription.setDiagnosis(prescriptionApiRequest.getDiagnosis());
            prescription.setMedicines(prescriptionApiRequest.getMedicines());
            prescription.setNextVisitDate(prescriptionApiRequest.getNextVisitDate());


            Prescription pres = prescriptionServiceImp.save(prescription);
            response.setId(pres.getPrescriptionId());
            response.setMessage(" Successfull ");

            return ResponseEntity.ok(response);


        } catch (PrescriptionApiException e) {

            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new PrescriptionApiExceptionResponse(null, "Bad Request: " + e.getMessage()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PrescriptionApiExceptionResponse(null, "An unexpected error occurred"));
        }

    }

    @GetMapping("/all")
    public List<Prescription> prescriptions() {
        try {
            List<Prescription> em = prescriptionServiceImp.findall();

            return em;
        } catch (Exception e) {
            throw new PrescriptionApiException("No Prescription Data Found");
        }

    }

    @DeleteMapping("/prescription/delete/{id}")
    public ResponseEntity<PrescriptionApiResponse> deleteData(@PathVariable int id) {
        try {
            PrescriptionApiResponse response = new PrescriptionApiResponse();
            int temp = prescriptionServiceImp.delete(id);
            if (temp == 1) {
                response.setMessage(" Successfully deleted the Prescription : " + id);
                return ResponseEntity.ok(response);
            } else {
                response.setMessage(" Prescription with this ID : " + id + " not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

            }
        } catch (Exception e) {
            throw new PrescriptionApiException("Prescription with this ID : " + id + " not found.");
        }


    }


}
