package com.enigma.trashbank.models.saldo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SaldoRequest {

    @NotNull
    private Integer memberId;

    @NotNull
    private Long nominal;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
}
