package com.soniyaprojects.onlinestoreapp.models;

import android.arch.persistence.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Ranking {

    @SerializedName("")
    private int id;

    @SerializedName("ranking")
    private String ranking;

    @SerializedName("products")
    private List<Product> productList;

}
