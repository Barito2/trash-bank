package com.enigma.trashbank.models.member;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class MemberModel {

    private Integer id;

    @NotBlank
    @Size(min = 1)
    private String name;

    @NotBlank
    @Size(min = 1, max = 20)
    private String gender;

    @NotBlank
    @Size(min = 1, max = 15)
    private String phone;

    @NotBlank
    @Size(min = 1)
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
