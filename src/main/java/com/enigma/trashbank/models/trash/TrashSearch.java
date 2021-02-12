package com.enigma.trashbank.models.trash;


import com.enigma.trashbank.models.PageSearch;

public class TrashSearch extends PageSearch {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
