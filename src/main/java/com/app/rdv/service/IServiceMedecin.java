package com.app.rdv.service;

import com.app.rdv.Entities.Medecin;
import com.app.rdv.Entities.Rdv;

import java.util.List;

public interface IServiceMedecin {


    public Medecin getMedecinById(int id);
    public List<Medecin> getAllMedecins();
    public Medecin  creationMedecin(Medecin medecin);
    public Medecin  updateMedecin(Medecin medecin);
    public void deleteMedecin(int id);
}

