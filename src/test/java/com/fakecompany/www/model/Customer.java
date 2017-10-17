package com.fakecompany.www.model;


public class Customer {

    private String firstName;
    private String secondName;
    private String address;
    private String postcode;
    private String town;
    private String phone;
    private String email;

    private Customer(){
        this.firstName = "Den";
        this.secondName = "Gu";
        this.address = "dfdfdfdfdf";
        this.postcode = "12345";
        this.town = "Prague";
        this.phone = "1234567";
        this.email = "mynewtestemail23@gmail.com";
    }

    public static Customer getCustomer(){
        return new Customer();
    }

    public String getFirstName() {
        return firstName;
    }
    public String getAddress() {
        return address;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getTown() {
        return town;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
