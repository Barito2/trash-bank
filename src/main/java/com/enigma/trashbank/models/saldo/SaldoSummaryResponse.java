package com.enigma.trashbank.models.saldo;

import com.enigma.trashbank.models.member.MemberModel;

public class SaldoSummaryResponse {

    private MemberModel member;
    private Long nominal;

    public SaldoSummaryResponse(MemberModel member, Long nominal) {
        this.member = member;
        this.nominal = nominal;
    }

    public SaldoSummaryResponse() {
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
