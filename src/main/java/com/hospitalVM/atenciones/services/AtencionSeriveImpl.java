package com.hospitalVM.atenciones.services;

import com.hospitalVM.atenciones.exceptions.AtecionException;
import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.repositories.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AtencionSeriveImpl implements AtencionService{

    @Autowired
    private AtencionRepository atencionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Atencion> findAll() {
        return this.atencionRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Atencion findById(Long id) {
        return this.atencionRepository.findById(id).orElseThrow(
                () -> new AtecionException("Atencion no encontrada")
        );
    }

    @Transactional
    @Override
    public Atencion save(Atencion atencion) {
        if(this.findById(atencion.getAtencionId()) != null){
            throw  new AtecionException("Atencion ya existe");
        }
        return this.atencionRepository.save(atencion);
    }

    @Override
    public void deleteById(Long id) {
    this.atencionRepository.deleteById(id);
    }

    @Override
    public Atencion updateById(Long id, Atencion atencion) {
        return this.atencionRepository.findById(id).map(element -> {
            element.setComentario(atencion.getComentario());
            element.setCosto(atencion.getCosto());
            element.setHoraAtencion(atencion.getHoraAtencion());
            return this.atencionRepository.save(element);
        }).orElseThrow(
                () -> new AtecionException("Atencion no encontrada")
        );
    }
}
