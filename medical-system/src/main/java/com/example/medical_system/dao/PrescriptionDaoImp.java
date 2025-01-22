package com.example.medical_system.dao;


import com.example.medical_system.entity.Prescription;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class PrescriptionDaoImp {

    private EntityManager entityManager;

    @Autowired
    public PrescriptionDaoImp(EntityManager entityManager)
    {
        this.entityManager=entityManager;
    }


    public Prescription save(Prescription prescription)
    {

        entityManager.persist(prescription);
        return prescription;

    }


    public List<Prescription> findall()
    {
        TypedQuery<Prescription> query=entityManager.createQuery("from Prescription", Prescription.class);

        List<Prescription> prescriptionList=query.getResultList();

        return prescriptionList;
    }




    public List<Prescription> getPrescriptionsByDateRange(LocalDate startDate, LocalDate endDate) {
        TypedQuery<Prescription> query = entityManager.createQuery(
                "from Prescription where prescriptionDate between :startDate and :endDate",
                Prescription.class
        );


        query.setParameter("startDate", java.sql.Date.valueOf(startDate));
        query.setParameter("endDate", java.sql.Date.valueOf(endDate));

        return query.getResultList();
    }


    public int delete(int id)
    {
        Query query=entityManager.createQuery("Delete from Prescription where prescriptionId=:id");
        query.setParameter("id",id);
        int em= query.executeUpdate();

        return em;

    }

    public Prescription findByID(int prescriptionId)
    {
        Prescription em=entityManager.find(Prescription.class,prescriptionId);
        return em;
    }

    public Prescription update(Prescription prescription)
    {

        entityManager.merge(prescription);
        return prescription;

    }

}
