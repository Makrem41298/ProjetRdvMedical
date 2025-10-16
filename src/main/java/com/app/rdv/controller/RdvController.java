package com.app.rdv.controller;

import com.app.rdv.Entities.Rdv;
import com.app.rdv.service.IServiceRDV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rdv")
public class RdvController {

    @Autowired
    private IServiceRDV serviceRDV;

    // ✅ Get all RDVs
    @GetMapping("/all")
    public List<Rdv> getAllRdv() {
        return serviceRDV.getAllRdv();
    }

    // ✅ Get RDV by ID
    @GetMapping("/{id}")
    public Rdv getRdvById(@PathVariable int id) {
        return serviceRDV.getRdvById(id);
    }

    // ✅ Create RDV
    @PostMapping("/create")
    public ResponseEntity<?> createRdv(@RequestBody Rdv rdv) {
        Rdv rdv1 = serviceRDV.creationRdv(rdv);
        if(rdv1 != null)
            return  new ResponseEntity<>(rdv1, HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Rdv not ajoute",HttpStatus.NOT_ACCEPTABLE);

    }

    // ✅ Update RDV
    @PutMapping("/update/{id}")
    public Rdv updateRdv(@PathVariable int id, @RequestBody Rdv rdv) {
        rdv.setId(id);
        return serviceRDV.updateRdv(rdv);
    }

    // ✅ Delete RDV
    @DeleteMapping("/delete/{id}")
    public String deleteRdv(@PathVariable int id) {
        serviceRDV.deleteRdv(id);
        return "Rendez-vous supprimé avec succès avec ID : " + id;
    }
}
