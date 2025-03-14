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

    @Test
    void testRestar() {
        Integer valor1 = 0;
        Integer valor2 = 3;
        Calculadora calculadora = new Calculadora();
        Integer esperado = 3;
        Integer resultado = calculadora.restar(valor1, valor2);
        assertAll(() -> {
            assertEquals(esperado, resultado, () -> "El valor deberia ser " + esperado);
        }, () -> {
            assertTrue(calculadora.restar(valor1, valor2) == esperado, () -> "El valor deberia ser " + esperado);
        });
    }
}