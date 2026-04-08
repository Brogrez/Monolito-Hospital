package com.hospitalVM.atenciones.repositories;

import com.hospitalVM.atenciones.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByRun(String run);
}
