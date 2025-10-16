package com.app.rdv.repository;

import com.app.rdv.Entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository <Medecin,Integer> {
    Medecin getMedecinById(int id);
}
