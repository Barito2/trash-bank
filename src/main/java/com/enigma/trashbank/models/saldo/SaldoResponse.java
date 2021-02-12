package com.enigma.trashbank.models.saldo;

import com.enigma.trashbank.models.member.MemberModel;
import com.enigma.trashbank.models.trash.TrashElement;

public class SaldoResponse {

    private Integer id;
    private MemberModel trash;
    private Long nominal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MemberModel getTrash() {
        return trash;
    }

    public void setTrash(MemberModel trash) {
        this.trash = trash;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }
}
