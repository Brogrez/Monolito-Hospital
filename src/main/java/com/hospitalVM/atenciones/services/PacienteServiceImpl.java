package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.PacienteException;
import com.hospitalVM.atenciones.models.Paciente;
import com.hospitalVM.atenciones.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService{


    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> findByAll() {
        return this.pacienteRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findById(Long id) {
        return this.pacienteRepository.findById(id).orElseThrow(
                () -> new PacienteException("paciente no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByCorreo(String correo) {
        return this.pacienteRepository.findByCorreo(correo).orElseThrow(
                () -> new PacienteException("paciente no encontrado")
        );
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente findByRut(String rut) {
        return this.pacienteRepository.findByRut(rut).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }

    @Transactional
    @Override
    public Paciente Save(Paciente paciente) {
        if(this.findByCorreo(paciente.getCorre()) != null){
            throw new PacienteException("paciente ya existe");
        }
        if(this.findByRut(paciente.getRut()) != null){
            throw new PacienteException("paciente ya existe");
        }
        return this.pacienteRepository.save(paciente);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        this.pacienteRepository.deleteById(id);
    }


    @Override
    public Paciente updateById(Long id, Paciente paciente) {
        return this.pacienteRepository.findById(id).map(element -> {
            element.setNombre(paciente.getNombre());
            element.setApellido(paciente.getApellido());
            element.setFechaNacimiento(paciente.getFechaNacimiento());
            return this.pacienteRepository.save(element);
        }).orElseThrow(
                () -> new PacienteException("Paciente no encontrado")
        );
    }
}