package com.soniyaprojects.onlinestoreapp.models;

import com.google.gson.annotations.SerializedName;
import com.soniyaprojects.onlinestoreapp.db.model.Tax;
import com.soniyaprojects.onlinestoreapp.db.model.Variants;

import java.util.List;

public class Product {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("date_added")
    private String dateAdded;

    @SerializedName("variants")
    private List<Variants> variants;

    @SerializedName("tax")
    private Tax tax;

    @SerializedName("view_count")
    private long viewCount;

    @SerializedName("order_count")
    private long OrderCount;

    @SerializedName("shares")
    private long numberOfShares;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public long getOrderCount() {
        return OrderCount;
    }

    public void setOrderCount(long orderCount) {
        OrderCount = orderCount;
    }

    public long getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(long numberOfShares) {
        this.numberOfShares = numberOfShares;
    }
}
