package com.enigma.trashbank.entities;

public class SaldoSummary {

    private Saldo saldo;
    private Long nominal;

    public SaldoSummary(Saldo saldo, Long nominal) {
        this.saldo = saldo;
        this.nominal = nominal;
    }

    public Saldo getSaldo() {
        return saldo;
    }

    public void setSaldo(Saldo saldo) {
        this.saldo = saldo;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
}
