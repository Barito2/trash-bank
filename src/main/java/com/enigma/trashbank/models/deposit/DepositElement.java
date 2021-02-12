package com.enigma.trashbank.models.deposit;

import com.enigma.trashbank.models.member.MemberModel;
import com.enigma.trashbank.models.trash.TrashElement;

public class DepositElement {
    private Integer id;
    private TrashElement trash;
    private MemberModel mamber;
    private Double weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TrashElement getTrash() {
        return trash;
    }

    public void setTrash(TrashElement trash) {
        this.trash = trash;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public MemberModel getMamber() {
        return mamber;
    }

    public void setMamber(MemberModel mamber) {
        this.mamber = mamber;
    }
}
