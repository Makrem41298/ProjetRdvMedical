package com.app.rdv.service;

import com.app.rdv.Entities.Rdv;
import com.app.rdv.repository.RdvRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class RdvService implements IServiceRDV{
    RdvRepository rdvRepository;

    @Override
    public Rdv getRdvById(int id) {
        return rdvRepository.getRdvById(id);
    }

    @Override
    public List<Rdv> getAllRdv() {
        return rdvRepository.findAll();
    }

    @Override
    public Rdv creationRdv(Rdv rdv) {
        Rdv rdv1 = rdvRepository.findByPatientIdAndDateRdv(rdv.getPatient().getId(), rdv.getDateRdv());
        Rdv rdv2 = rdvRepository.findByMedecinIdAndDateRdv(rdv.getMedecin().getId(), rdv.getDateRdv());
        if(rdv1 == null && rdv2 == null) {
            return rdvRepository.save(rdv);
        }
        return null;
    }

    @Override
    public Rdv updateRdv(Rdv rdv ){
        return rdvRepository.save(rdv);
    }

    @Override
    public void deleteRdv(int id) {
        rdvRepository.deleteById(id);

    }
}
