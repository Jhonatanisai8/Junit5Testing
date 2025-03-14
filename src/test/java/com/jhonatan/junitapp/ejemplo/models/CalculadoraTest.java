package com.jhonatan.junitapp.ejemplo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    void testSumar() {
        Integer valor1 = -5;
        Integer valor2 = 1;
        Calculadora calculadora = new Calculadora();
        Integer esperado = -4;
        Integer resultado = calculadora.sumar(valor1, valor2);
        assertEquals(esperado, resultado, () -> "El valor deberia ser " + esperado);
    }
}