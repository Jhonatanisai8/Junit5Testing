package com.jhonatan.junitapp.ejemplo.models;

import java.math.BigDecimal;

public class Cuenta {
    private String propietario;
    private BigDecimal saldo;

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
