package com.app.rdv.repository;

import com.app.rdv.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository  extends JpaRepository<Patient,Integer> {
    Patient getPatientById(int id);
}
