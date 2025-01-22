package com.example.medical_system.service;


import com.example.medical_system.dao.PrescriptionDaoImp;
import com.example.medical_system.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PrescriptionServiceImp {

    private PrescriptionDaoImp prescriptionDaoImp;


    @Autowired
    public PrescriptionServiceImp(PrescriptionDaoImp prescriptionDaoImp)
    {
        this.prescriptionDaoImp=prescriptionDaoImp;

    }


    @Transactional
    public Prescription save(Prescription  prescription)

    {
        Prescription pres=prescriptionDaoImp.save(prescription);
        return pres;
    }

    public List<Prescription> findall()
    {
        List<Prescription> em=prescriptionDaoImp.findall();

        return em;

    }



    public List<Prescription> getPrescriptionsByDateRange(LocalDate startDate, LocalDate endDate)
    {
        List<Prescription> em=prescriptionDaoImp.getPrescriptionsByDateRange(startDate, endDate);

        return em;

    }

    @Transactional
    public int delete(int id)
    {
        int em=prescriptionDaoImp.delete(id);

        return em;

    }

    public Prescription findByID(int prescriptionId)
    {
        Prescription em=prescriptionDaoImp.findByID(prescriptionId);

        return em;

    }

    @Transactional
    public Prescription update(Prescription prescription) {
        Prescription pres=prescriptionDaoImp.update(prescription);
        return pres;
    }
}
