package com.enigma.trashbank.models.saldo;


import com.enigma.trashbank.models.PageSearch;

public class SaldoSearch extends PageSearch {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
