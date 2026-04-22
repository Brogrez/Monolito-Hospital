package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.models.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> findByAll();
    Paciente findById(Long id);
    Paciente findByCorreo(String correo);
    Paciente findByRut(String rut);
    Paciente save(Paciente paciente);
    void deleteById(Long id);
    Paciente updateById(Long id, Paciente paciente);
}
