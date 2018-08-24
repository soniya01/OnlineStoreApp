package com.soniyaprojects.onlinestoreapp.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "ranking")
public class Rankings {

    @NonNull
    @PrimaryKey()
    private long id;

    @ColumnInfo(name = "ranking")
    private String ranking;

    @Ignore
    @ColumnInfo(name = "products")
    private List<Product> productList;


    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
