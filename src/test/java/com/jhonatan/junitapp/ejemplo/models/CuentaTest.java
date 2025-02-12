package com.jhonatan.junitapp.ejemplo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {


    /**
     * prueba que se pase un propietario
     */
    @Test
    void testNombreCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setPropietario("JhonSai");
        String esperado = "JhonSai";
        String actual = cuenta.getPropietario();
        assertEquals(esperado, actual);
    }
}