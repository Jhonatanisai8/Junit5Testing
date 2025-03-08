package com.jhonatan.junitapp.ejemplo.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nombre;
    private List<Cuenta> cuentas;

    public Banco() {
        this.cuentas = new ArrayList<Cuenta>();
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void transferir(Cuenta cOrigen, Cuenta cDestino, BigDecimal valor) {
        cOrigen.debito(valor);
        cDestino.credito(valor);
    }

    public void addCuenta(Cuenta c) {
        this.cuentas.add(c);
    }
}
