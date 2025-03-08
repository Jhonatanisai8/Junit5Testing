package com.jhonatan.junitapp.ejemplo.models;

import com.jhonatan.junitapp.ejemplo.exceptions.DineroInsuficienteException;
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

    @Test
    void testDineroInsufienteException() {
        Cuenta cuenta = new Cuenta("JhonSai", new BigDecimal("1000.12345"));
        DineroInsuficienteException dineroInsuficienteException = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1400));
        });
        assertEquals("Dinero Insuficiente", dineroInsuficienteException.getMessage());
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta01 = new Cuenta("JhonSai", new BigDecimal("3000"));
        Cuenta cuenta02 = new Cuenta("JhonDa", new BigDecimal("1000.8989"));
        Banco banco = new Banco();
        banco.setNombre("Banco Nacional");
        banco.transferir(cuenta02, cuenta01, new BigDecimal(500));
        assertEquals("500.8989", cuenta02.getSaldo().toString());
    }

    @Test
    void testRelacionBancoCuentas() {
        Cuenta cuenta01 = new Cuenta("JhonSai", new BigDecimal("3000"));
        Cuenta cuenta02 = new Cuenta("JhonDa", new BigDecimal("1000.8989"));
        Banco banco = new Banco();
        banco.setNombre("Banco Nacional");

        banco.addCuenta(cuenta01);
        banco.addCuenta(cuenta02);

        banco.transferir(cuenta02, cuenta01, new BigDecimal(500));
        assertEquals("3500", cuenta01.getSaldo().toPlainString());
        assertEquals("500.8989", cuenta02.getSaldo().toString());

        assertEquals(2, banco.getCuentas().size());
        assertEquals("Banco Nacional", cuenta01.getBanco().getNombre());
        //buscamos una cuenta por el nombre con el api stream
        assertEquals("JhonSai", banco.getCuentas()
                .stream()
                .filter(cuenta -> cuenta.getPropietario().equals("JhonSai"))
                .findFirst()
                .get()
                .getPropietario());
    }


}