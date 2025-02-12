package com.jhonatan.junitapp.ejemplo.models;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {


    /**
     * prueba que se pase un propietario a la cuenta
     */
    @Test
    void testPropietarioCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        //cuenta.setPropietario("JhonSai");
        String esperado = "JhonSai";
        String actual = cuenta.getPropietario();
        assertEquals(esperado, actual);
        assertTrue(esperado.equals(actual));
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        int numero = cuenta.getSaldo().compareTo(BigDecimal.ZERO);
        assertFalse(numero < 0); //si es mayor el numero a cero el saldo es negativo
        assertTrue(numero > 0);//si es mayor que 0, el saldo es positivo
    }
}