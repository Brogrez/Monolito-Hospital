package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Medico;

import java.util.List;

public interface MedicoService {

    List<Medico> findAll();
    Medico findById(Long id);
    Medico findByRun(String run);
    Medico save(Medico medico);
    void deletedById(Long id);
    Medico updateById(Long id, Medico medico);

}
