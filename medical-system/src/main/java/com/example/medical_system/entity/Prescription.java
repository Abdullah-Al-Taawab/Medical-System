package com.example.medical_system.entity;


import com.example.medical_system.request.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Entity
public class Prescription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    @NotNull(message = "Prescription Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prescriptionDate;

    @NotNull(message = "Patient Name is required")
    @Size(min = 1, max = 100, message = "Patient Name must be between 1 and 100 characters")
    private String patientName;

    @Min(value = 0, message = "Age must be a positive number")
    @Max(value = 150, message = "Age must be less than or equal to 150")
    private int patientAge;

    @Enumerated(EnumType.STRING)
    private Gender patientgender;

    private String diagnosis;

    private String medicines;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date nextVisitDate;



    public Prescription(Date prescriptionDate, String patientName, int patientAge, Gender patientgender, String diagnosis, String medicines, Date nextVisitDate) {
        this.prescriptionDate = prescriptionDate;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.patientgender = patientgender;
        this.diagnosis = diagnosis;
        this.medicines = medicines;
        this.nextVisitDate = nextVisitDate;
    }

    public Prescription() {
    }


    public int getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(int prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public void setPrescriptionDate(Date prescriptionDate) {
        this.prescriptionDate = prescriptionDate;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Gender getPatientgender() {
        return patientgender;
    }

    public void setPatientgender(Gender patientgender) {
        this.patientgender = patientgender;
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
