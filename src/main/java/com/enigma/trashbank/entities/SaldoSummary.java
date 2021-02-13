package com.enigma.trashbank.entities;

public class SaldoSummary {

    private Member member;
    private Long nominal;

    public SaldoSummary(Member member, Long nominal) {
        this.member = member;
        this.nominal = nominal;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
}
