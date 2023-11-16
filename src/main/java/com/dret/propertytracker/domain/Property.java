package com.dret.propertytracker.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.web.bind.annotation.CrossOrigin;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin
public class Property {

    long propertyId;
    String address;
    String city;
    String state;
    String zipcode;

    public Property() {

    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Property(long propertyId, String address, String city, String state, String zipcode) {
        this.propertyId = propertyId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Property(String address, String city, String state, String zipcode) {
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
