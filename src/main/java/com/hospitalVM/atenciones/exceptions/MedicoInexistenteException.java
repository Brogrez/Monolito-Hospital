package com.hospitalVM.atenciones.exceptions;

public class MedicoInexistenteException extends RuntimeException {
    public MedicoInexistenteException(String message) {
        super(message);
    }
}
