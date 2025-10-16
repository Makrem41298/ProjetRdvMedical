package com.app.rdv.controller;

import com.app.rdv.Entities.Medecin;
import com.app.rdv.service.IServiceMedecin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/medecin")
public class MedecinController {

    @Autowired
    private IServiceMedecin serviceMedecin;

    // ✅ Get all medecins
    @GetMapping("/all")
    public List<Medecin> getAllMedecins() {
        return serviceMedecin.getAllMedecins();
    }

    // ✅ Get medecin by id
    @GetMapping("/{id}")
    public Medecin getMedecinById(@PathVariable int id) {
        return serviceMedecin.getMedecinById(id);
    }

    // ✅ Create new medecin
    @PostMapping("/create")
    public Medecin createMedecin(@RequestBody Medecin medecin) {
        return serviceMedecin.creationMedecin(medecin);
    }

    // ✅ Update medecin
    @PutMapping("/update/{id}")
    public Medecin updateMedecin(@PathVariable int id, @RequestBody Medecin medecin) {
        medecin.setId(id);
        return serviceMedecin.updateMedecin(medecin);
    }

    // ✅ Delete medecin
    @DeleteMapping("/delete/{id}")
    public String deleteMedecin(@PathVariable int id) {
        serviceMedecin.deleteMedecin(id);
        return "Médecin supprimé avec succès avec ID : " + id;
    }
}
