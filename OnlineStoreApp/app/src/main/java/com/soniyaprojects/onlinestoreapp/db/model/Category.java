package com.soniyaprojects.onlinestoreapp.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "category")
public class Category {


    private long id;

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "category_id")
    private long categoryId;

    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    @ColumnInfo(name = "products")
    private List<Integer> productIDs;

    @ColumnInfo(name = "child_categories")
    private String subCategoryIDs;

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Integer> getProductIDs() {
        return productIDs;
    }

    public void setProductIDs(List<Integer> productIDs) {
        this.productIDs = productIDs;
    }

    public String getSubCategoryIDs() {
        return subCategoryIDs;
    }

    public void setSubCategoryIDs(String subCategoryIDs) {
        this.subCategoryIDs = subCategoryIDs;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
