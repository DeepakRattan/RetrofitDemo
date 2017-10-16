package com.example.deepakrattan.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by deepak.rattan on 10/16/2017.
 */

public class Employee {
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;

    public Employee(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
