package com.soniyaprojects.onlinestoreapp.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tax")
public class Tax {

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "tax_id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "value")
    private double value;

    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
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
