package com.enigma.trashbank.models.Trash;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TrashRequest {

    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    private Integer price;

    private Integer unitId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }
}
