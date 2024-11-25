package com.feldmann.hexagonal.application.core.domain;

public class Address {

    private String street;

    private String city;

    private String state;

    public Address() {

    }

    public Address(String city, String street, String state) {
        this.city = city;
        this.street = street;
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
