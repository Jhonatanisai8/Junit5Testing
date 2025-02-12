package com.jhonatan.junitapp.ejemplo.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Cuenta {
    private String propietario;
    private BigDecimal saldo;

    public Cuenta(String propietario, BigDecimal saldo) {
        this.propietario = propietario;
        this.saldo = saldo;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cuenta cuenta)) return false;
        return Objects.equals(propietario, cuenta.propietario) && Objects.equals(saldo, cuenta.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(propietario, saldo);
    }
}
