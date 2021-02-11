package com.enigma.trashbank.models.member;

import com.enigma.trashbank.models.PageSearch;

public class MemberSearch extends PageSearch {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
