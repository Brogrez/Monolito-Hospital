package com.hospitalVM.atenciones.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long medicoId;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "El campo run no puede ser vacio")
    @Pattern(regexp = "\\d(1,8)-[\\dKk]", message = "el formato del run debe ser xxxxxxxx-x")
    private String run;

    @Column(name="nombre_completo", nullable = false)
    @NotBlank(message = "el campo nombre completo no puede ser vacio")
    private String nombreCompleto;

    @Column(name="jefe_turno", nullable = false)
    private Boolean jefeTurno;
    @Embedded
    private Audit audit = new Audit();
}
