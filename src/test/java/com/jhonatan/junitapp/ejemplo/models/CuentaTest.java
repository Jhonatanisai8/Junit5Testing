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
        assertNotNull(actual);

        assertEquals(esperado, actual);
        assertTrue(esperado.equals(actual));
    }

    @Test
    void testSaldoCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertNotNull(cuenta.getSaldo());
        int numero = cuenta.getSaldo().compareTo(BigDecimal.ZERO);
        assertFalse(numero < 0); //si es mayor el numero a cero el saldo es negativo
        assertTrue(numero > 0);//si es mayor que 0, el saldo es positivo
    }

    @Test
    void testReferenciaCuenta() {
        Cuenta cuenta02 = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        Cuenta cuenta01 = new Cuenta("JhonSai", new BigDecimal("1000.12345"));

        //assertNotEquals(cuenta01, cuenta02);
        assertEquals(cuenta01, cuenta02);
    }

    @Test
    void testDebitoCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Test
    void testCreditoCuenta() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        cuenta.credito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(1100, cuenta.getSaldo().intValue());
        assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
    }

}