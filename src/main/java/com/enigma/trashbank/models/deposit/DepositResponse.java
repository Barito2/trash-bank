package com.enigma.trashbank.models.deposit;

import com.enigma.trashbank.models.member.MemberModel;
import com.enigma.trashbank.models.trash.TrashElement;

public class DepositResponse {

    private Integer id;
    private TrashElement trash;
    private MemberModel member;
    private Double weight;
    private Long price;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
