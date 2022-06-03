package com.email.service.datamodel;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public")
public class Address {
    @Id
    private int user_id;
    private int number;
    private String city;
    private String street;

    public Address(int user_id, int number, String city, String street){

    }

    public Address() {

    }

    public int getUser_id() {
        return user_id;
    }

    public int getNumber() {
        return number;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}
