package com.enigma.trashbank.models.saldo;

import com.enigma.trashbank.models.member.MemberModel;
import com.enigma.trashbank.models.trash.TrashElement;

public class SaldoElement {
    private Integer id;
    private MemberModel member;
    private Long saldo;

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

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }
}
