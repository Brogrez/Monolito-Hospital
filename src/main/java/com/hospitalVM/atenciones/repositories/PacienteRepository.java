package com.hospitalVM.atenciones.repositories;

import com.hospitalVM.atenciones.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    //METODO QUE ME PERMITE BUSCAR POR RUT
    Optional<Paciente> findByRut(String rut);

    //METODO QUE PERMITE BUSCAR POR CORREO
    Optional<Paciente> findByCorreo(String correo);
}
