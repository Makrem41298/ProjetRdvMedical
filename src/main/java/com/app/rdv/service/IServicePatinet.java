package com.app.rdv.service;

import com.app.rdv.Entities.Patient;

import java.util.List;

public interface IServicePatinet {


    public Patient getPatientById(int id);
    public List<Patient> getAllPatients();
    public Patient crationPatient(Patient patient);
    public Patient updatePatient(Patient patient);
    public void deletePatient(int id);

}
