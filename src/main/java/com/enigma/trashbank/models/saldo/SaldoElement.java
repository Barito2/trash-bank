package com.enigma.trashbank.models.saldo;

import com.enigma.trashbank.models.member.MemberModel;

public class SaldoElement {
    private Integer id;
    private MemberModel member;
    private Long nominal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
}
