package com.soniyaprojects.onlinestoreapp.models;

import com.google.gson.annotations.SerializedName;

public class Variants {

    @SerializedName("id")
    private int id;

    @SerializedName("color")
    private String colorString;

    @SerializedName("size")
    private int size;

    @SerializedName("price")
    private double price;

    public Variants(int id, String colorString, int size, double price) {
        this.id = id;
        this.colorString = colorString;
        this.size = size;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColorString() {
        return colorString;
    }

    public void setColorString(String colorString) {
        this.colorString = colorString;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
