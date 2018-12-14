package com.example.leslieg.sampleapp;

public class Contact {

    private String personName;
    private String personContact;

    public Contact(String name, String phone) {
        personName = name;
        personContact = phone;
    }

    public String getName() {
        return personName;
    }

    public String getContact() {
        return personContact;
    }

    public void setName(String newname) {
        personName = newname;
    }
}
