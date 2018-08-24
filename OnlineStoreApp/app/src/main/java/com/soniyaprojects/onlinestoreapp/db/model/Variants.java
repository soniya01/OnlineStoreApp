package com.soniyaprojects.onlinestoreapp.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "variants", foreignKeys = @ForeignKey(entity = Product.class, parentColumns = "product_id", childColumns = "variant_id"), indices = {@Index("variant_id")})
public class Variants {


    private long id;

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "variant_id")
    private long variantId;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "size")
    private int size;

    @ColumnInfo(name = "price")
    private double price;

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public long getVariantId() {
        return variantId;
    }

    public void setVariantId(long variantId) {
        this.variantId = variantId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
