package com.enigma.trashbank.models.deposit;


import com.enigma.trashbank.models.PageSearch;

public class DepositSearch extends PageSearch {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
