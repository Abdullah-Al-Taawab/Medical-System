package com.example.medical_system.controller;

import com.example.medical_system.entity.Prescription;
import com.example.medical_system.service.PrescriptionServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class DashboardController {

    private PrescriptionServiceImp prescriptionServiceImp;

    @Autowired
    public DashboardController(PrescriptionServiceImp prescriptionServiceImp) {
        this.prescriptionServiceImp = prescriptionServiceImp;
    }

    @GetMapping("/prescriptions")
    public String getPrescriptions(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
            Model model) {

        if (startDate == null || endDate == null) {
            startDate = LocalDate.now().withDayOfMonth(1);
            endDate = LocalDate.now();
        }
        List<Prescription> prescriptions = prescriptionServiceImp.getPrescriptionsByDateRange(startDate, endDate);

        model.addAttribute("prescriptions", prescriptions);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "prescriptionsDashboard";
    }

    @GetMapping("/prescription/create")
    public String createPrescriptionForm(Model model) {
        model.addAttribute("prescription", new Prescription());
        return "createPrescription";
    }

    @PostMapping("/prescription/add")
    public String createPrescription(@Valid @ModelAttribute("prescription") Prescription prescription, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "createPrescription";
        }

        try {

            Prescription savedPrescription = prescriptionServiceImp.save(prescription);


            model.addAttribute("successMessage", "Prescription added successfully!");


            return "prescriptionsDashboard";
        } catch (Exception e) {

            model.addAttribute("errorMessage", "An error occurred while adding the prescription.");
            return "createPrescription";
        }
    }


    @GetMapping("/prescription/delete")
    public String showDeletePage() {
        return "deletePrescription";
    }

    @PostMapping("/prescription/delete")
    public String deletePrescription(@RequestParam("prescriptionId") int prescriptionId, Model model) {
        try {
            int isDeleted = prescriptionServiceImp.delete(prescriptionId);
            if (isDeleted == 1) {
                model.addAttribute("successMessage", " Successfully Deleted the Prescription : " + prescriptionId);
            } else {
                model.addAttribute("successMessage", " Prescription with this ID : " + prescriptionId + " not found. ");
            }

            return "prescriptionsDashboard";
        } catch (Exception e) {

            model.addAttribute("errorMessage", "An error occurred while adding the prescription.");
            return "deletePrescription";
        }
    }


    @GetMapping("/prescription/edit/{id}")
    public String showEditPage(@PathVariable("id") int id, Model model) {
        try {
            Prescription prescription = prescriptionServiceImp.findByID(id);
            if (prescription != null) {
                model.addAttribute("prescription", prescription);
                return "editPrescription";
            } else {
                model.addAttribute("errorMessage", "Prescription not found with ID: " + id);
                return "prescriptionsDashboard";
            }
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while fetching the prescription data.");
            return "prescriptionsDashboard";
        }
    }

    @PostMapping("/prescription/edit")
    public String updatePrescription(@ModelAttribute("prescription") Prescription prescription, Model model) {
        try {
            Prescription pres =prescriptionServiceImp.update(prescription);
            model.addAttribute("successMessage", "Prescription updated successfully!");
            return "prescriptionsDashboard";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "An error occurred while updating the prescription.");
            return "editPrescription";
        }
    }
}

