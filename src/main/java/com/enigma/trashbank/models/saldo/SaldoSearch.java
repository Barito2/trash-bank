package com.enigma.trashbank.models.saldo;


import com.enigma.trashbank.models.PageSearch;
import com.enigma.trashbank.models.member.MemberSearch;

public class SaldoSearch extends PageSearch {

    private MemberSearch member;

    public MemberSearch getMember() {
        return member;
    }

    public void setMember(MemberSearch member) {
        this.member = member;
    }
}
