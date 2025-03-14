package com.jhonatan.junitapp.ejemplo.models;

import com.jhonatan.junitapp.ejemplo.exceptions.DividirPorCeroException;
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

    @Test
    void testMultiplicar() {
        Integer valor1 = 0;
        Integer valor2 = 3;
        Calculadora calculadora = new Calculadora();
        Integer esperado = 3;
        Integer resultado = calculadora.multiplicar(valor1, valor2);
        assertAll(() -> {
            assertEquals(esperado, resultado, () -> "El valor deberia ser " + esperado);
        }, () -> {
            assertTrue(calculadora.restar(valor1, valor2) == esperado, () -> "El valor deberia ser " + esperado);
        });
    }

    @Test
    void testDividirException() {
        Integer valor1 = 6;
        Integer valor2 = 0;
        Calculadora calculadora = new Calculadora();
        DividirPorCeroException dividirPorCeroException = assertThrows(DividirPorCeroException.class, () -> {
            calculadora.dividir(valor1, valor2);
        });
        assertEquals("No se puede dividir entre 0", dividirPorCeroException.getMessage());
    }
}