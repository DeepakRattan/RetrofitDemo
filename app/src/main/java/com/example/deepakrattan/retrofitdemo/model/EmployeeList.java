package com.example.deepakrattan.retrofitdemo.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by deepak.rattan on 10/16/2017.
 */

public class EmployeeList {
    @SerializedName("employeeList")
    private ArrayList<Employee> employeeList;

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
