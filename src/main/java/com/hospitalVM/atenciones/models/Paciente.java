package com.hospitalVM.atenciones.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paciente_id")
    private Long pacienteId;

    @NotBlank(message = "el campo de rut no puede ser vacio")
    @Pattern(regexp = "\\d(1,8)-[\\dKk]", message = "el formato del run debe ser xxxxxxxx-x")
    private String rut;


    @NotBlank(message = "el campo nombre no puede ser vacio")
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "el campo apellido no puede ser vacio")
    @Column(nullable = false)
    private String apellido;

    @NotBlank(message = "el campo fecha no puede ser vacio")
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El correo no puede ser vacio")
    @Email
    private String Corre;

    @Embedded
    Audit audit = new Audit();
}
