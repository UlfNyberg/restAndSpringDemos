package com.example.demo.models;

/**
 * Created by: Ulf Nyberg
 * Date: 2021-04-08
 * Time: 14:41
 * Project: demo01
 * Copyright: MIT
 */
public class Kompis {

    protected int id;
    protected String name;
    protected String address;
    protected int phoneNumber;

    public Kompis (){}

    public Kompis (int id, String name, String address, int phoneNumber){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
