package com.soniyaprojects.onlinestoreapp.models;

import com.google.gson.annotations.SerializedName;

public class Tax {

    @SerializedName("name")
    private String name;

    @SerializedName("value")
    private double value;

    public Tax(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
