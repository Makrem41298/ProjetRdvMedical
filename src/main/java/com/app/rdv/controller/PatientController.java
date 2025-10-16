package com.app.rdv.controller;

import com.app.rdv.Entities.Patient;
import com.app.rdv.service.IServicePatinet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // Use RestController instead of Controller for REST APIs
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private IServicePatinet servicePatient;

    // Create Patient
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return servicePatient.crationPatient(patient);
    }

    // Get All Patients
    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return servicePatient.getAllPatients();
    }

    // Get Patient By ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable int id) {
        return servicePatient.getPatientById(id);
    }

    // Update Patient
    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        patient.setId(id); // make sure we update the correct patient
        return servicePatient.updatePatient(patient);
    }

    // Delete Patient
    @DeleteMapping("/delete/{id}")
    public void deletePatient(@PathVariable int id) {
        servicePatient.deletePatient(id);
    }
}
