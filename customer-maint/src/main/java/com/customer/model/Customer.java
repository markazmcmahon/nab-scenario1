package com.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String firstName;
    private String middleName;
    private String surname;
    private String initials;
    private String title;
    private String streetLine1;
    private String streetName;
    private String suburb;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String sex;
    private String maritalStatus;
    private int creditRating;
    private boolean isNabCustomer;

    public Customer() {}

    public Customer(Long id, String firstName, String middleName, String surname, String initials, String title,
                    String streetLine1, String streetName, String suburb, String city, String state, String country, String pinCode,
                    String sex, String maritalStatus, int creditRating, boolean isNabCustomer) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.initials = initials;
        this.title = title;
        this.streetLine1 = streetLine1;
        this.streetName = streetName;
        this.suburb = suburb;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.creditRating = creditRating;
        this.isNabCustomer = isNabCustomer;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getInitials() {
        return initials;
    }

    public String getTitle() {
        return title;
    }

    public String getStreetLine1() {
        return streetLine1;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getSex() {
        return sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public int getCreditRating() {
        return creditRating;
    }

    public boolean getIsNabCustomer() {
        return isNabCustomer;
    }

    public void setIsNabCustomer() {
        this.isNabCustomer = isNabCustomer;
    }

}
