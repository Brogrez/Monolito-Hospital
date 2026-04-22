package com.hospitalVM.atenciones.services;


import com.hospitalVM.atenciones.models.Atencion;

import java.util.List;

public interface AtencionService {
    List<Atencion> findAll();
    Atencion findById(Long id);
    Atencion save(Atencion atencion);
    void deleteById(Long id);
    Atencion updateById(Long id, Atencion atencion);
}
