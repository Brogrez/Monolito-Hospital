package com.hospitalVM.atenciones.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "atencion")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Atencion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atencion_id")
    private Long atencionId;

    @NotNull(message = "el campo hora atencion no puede ser nulo")
    @Column(name = "hora_atencion")
    private LocalDateTime horaAtencion;

    @NotNull(message = "el campo de costo no puede ser vacio")
    @Column(nullable = false)
    private Double costo;

    private String comentario;

    @Embedded
    Audit audit = new Audit();
}
