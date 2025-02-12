package com.jhonatan.junitapp.ejemplo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {


    /**
     * prueba que se pase un propietario a la cuenta
     */
    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        //cuenta.setPropietario("JhonSai");
        String esperado = "JhonSai";
        String actual = cuenta.getPropietario();
        assertEquals(esperado, actual);
        assertTrue(esperado.equals(actual));
    }
}