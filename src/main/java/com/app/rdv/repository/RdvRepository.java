package com.app.rdv.repository;

import com.app.rdv.Entities.Medecin;
import com.app.rdv.Entities.Patient;
import com.app.rdv.Entities.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface RdvRepository extends JpaRepository<Rdv, Integer> {

    Rdv getRdvById(int id);

    // ✅ Find RDV by Medecin and date
   Rdv findByMedecinIdAndDateRdv(int idMedecin, LocalDateTime dateRdv);

    // ✅ Find RDV by Patient and date
    Rdv findByPatientIdAndDateRdv(int idPatient, LocalDateTime dateRdv);
}
