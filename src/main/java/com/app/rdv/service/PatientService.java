package com.app.rdv.service;

import com.app.rdv.Entities.Patient;
import com.app.rdv.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class PatientService implements IServicePatinet{

        PatientRepository patientRepository;
    @Override
    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient crationPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientRepository.deleteById(id);

    }
}
