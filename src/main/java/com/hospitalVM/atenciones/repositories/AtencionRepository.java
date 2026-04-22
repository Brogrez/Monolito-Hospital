package com.hospitalVM.atenciones.repositories;

import com.hospitalVM.atenciones.models.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AtencionRepository extends JpaRepository<Atencion, Long> {

}
