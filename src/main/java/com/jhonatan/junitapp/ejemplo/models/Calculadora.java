package com.jhonatan.junitapp.ejemplo.models;

import com.jhonatan.junitapp.ejemplo.exceptions.DividirPorCeroException;

public class Calculadora {

    public Integer sumar(Integer valor01, Integer valor02) {
        return valor01 + valor02;
    }

    public Integer restar(Integer valor01, Integer valor02) {
        return valor01 - valor02;
    }

    public Integer dividir(Integer valor01, Integer valor02) throws DividirPorCeroException {
        try {
            return valor01 / valor02;
        } catch (ArithmeticException e) {
            throw new DividirPorCeroException("No se puede dividir por cero.");
        }
    }

    public Integer multiplicar(Integer valor01, Integer valor02) {
        return valor01 * valor02;
    }

}
