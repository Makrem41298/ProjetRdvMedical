package com.app.rdv.service;

import com.app.rdv.Entities.Medecin;
import com.app.rdv.repository.MedecinRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class MedecinService implements IServiceMedecin{
    MedecinRepository medecinRepository;

    @Override
    public Medecin getMedecinById(int id) {
        return medecinRepository.getMedecinById(id) ;
    }

    @Override
    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    @Override
    public Medecin creationMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public Medecin updateMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public void deleteMedecin(int id) {
        medecinRepository.deleteById(id);

    }
}
