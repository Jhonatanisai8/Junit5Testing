package com.jhonatan.junitapp.ejemplo.exceptions;

public class DineroInsuficienteException
        extends RuntimeException {
    public DineroInsuficienteException(String message) {
        super(message);
    }
}
