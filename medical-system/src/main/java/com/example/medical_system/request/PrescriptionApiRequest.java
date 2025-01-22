package com.example.medical_system.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.util.Date;

public class PrescriptionApiRequest {


    @NotNull(message = "Prescription Date is mandatory")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date prescriptionDate;

    @NotBlank(message = "Patient Name is mandatory")
    private String patientName;

    @NotNull
    @Min(value = 1, message = "Patient Age is mandatory")
    private int patientAge;

    @NotNull
    private Gender patientgender;

    private String diagnosis;

    private String medicines;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date nextVisitDate;



    public @NotNull Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(@NotNull Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
        this.prescriptionDate = prescriptionDate;
    }

    public @NotBlank(message = "Name is mandatory") String getPatientName() {
        return patientName;
    }

    public void setPatientName(@NotBlank(message = "Name is mandatory") String patientName) {
        this.patientName = patientName;
    }

    public @NotNull Gender getPatientgender() {
        return patientgender;
    }

    public void setPatientgender(@NotNull Gender patientgender) {
        this.patientgender = patientgender;
    }

    @NotNull
    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(@NotNull int patientAge) {
        this.patientAge = patientAge;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    public Date getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Date nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }
}
