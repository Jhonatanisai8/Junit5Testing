package com.jhonatan.junitapp.ejemplo.models;

import com.jhonatan.junitapp.ejemplo.exceptions.DineroInsuficienteException;

import java.math.BigDecimal;
import java.util.Objects;

public class Cuenta {
    private String propietario;
    private BigDecimal saldo;
    private Banco banco;

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

    public void debito(BigDecimal valor) throws DineroInsuficienteException {
        BigDecimal nuevoSaldo = this.saldo.subtract(valor);
        //no hay suficiente dinero y se lanza el error.
        if (nuevoSaldo.compareTo(BigDecimal.ZERO) < 0) {
            throw new DineroInsuficienteException("Dinero Insuficiente");
        }
        this.saldo = nuevoSaldo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public void credito(BigDecimal valor) {
        this.saldo = saldo.add(valor);
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
