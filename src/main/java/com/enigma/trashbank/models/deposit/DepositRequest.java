package com.enigma.trashbank.models.deposit;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DepositRequest {

    @NotNull
    private Integer trashId;

    @NotNull
    private Integer memberId;

    @NotNull
    private Double weight;

    public Integer getTrashId() {
        return trashId;
    }

    public void setTrashId(Integer trashId) {
        this.trashId = trashId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
