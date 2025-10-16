package com.app.rdv.service;

import com.app.rdv.Entities.Patient;
import com.app.rdv.Entities.Rdv;

import java.util.List;

public interface IServiceRDV {
    public Rdv getRdvById(int id);
    public List<Rdv> getAllRdv();
    public Rdv creationRdv(Rdv rdv);
    public Rdv updateRdv(Rdv rdv);
    public void deleteRdv(int id);
}
