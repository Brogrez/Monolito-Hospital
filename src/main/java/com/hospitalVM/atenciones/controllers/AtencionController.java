package com.hospitalVM.atenciones.controllers;

import com.hospitalVM.atenciones.models.Atencion;
import com.hospitalVM.atenciones.services.AtencionService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atenciones")
@Validated
public class AtencionController {

    @Autowired
    private AtencionService atencionService;

    @GetMapping
    public ResponseEntity<List<Atencion>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(atencionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(atencionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Atencion> save(@Valid @RequestBody Atencion atencion){
        return ResponseEntity.status(HttpStatus.CREATED).body(atencionService.save(atencion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> update(@PathVariable Long id,@Valid @RequestBody Atencion atencion){
        return ResponseEntity.status(HttpStatus.OK).body(atencionService.updateById(id, atencion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        atencionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
