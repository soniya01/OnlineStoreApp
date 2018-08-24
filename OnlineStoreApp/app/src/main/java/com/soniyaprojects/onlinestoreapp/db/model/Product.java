package com.soniyaprojects.onlinestoreapp.db.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.List;

@Entity(tableName = "product", foreignKeys = {@ForeignKey(entity = Category.class, parentColumns = "category_id", childColumns = "product_id"),
        @ForeignKey(entity = Tax.class, parentColumns = "tax_id", childColumns = "product_id"),
        @ForeignKey(entity = Rankings.class, parentColumns = "id", childColumns = "product_id")}, indices = {@Index("product_id")})
public class Product {

    private long id;

    @NonNull
    @PrimaryKey()
    @ColumnInfo(name = "product_id")
    private long productId;

    @ColumnInfo(name = "category_id")
    public long categoryId;

    @ColumnInfo(name = "product_name")
    private String name;

    @ColumnInfo(name = "date_added")
    private String dateAdded;

    @Ignore
    @ColumnInfo(name = "variants")
    private List<Variants> variants;

    @ColumnInfo(name = "tax_id")
    private long taxId;

    @ColumnInfo(name = "view_count")
    private long viewCount;

    @ColumnInfo(name = "order_count")
    private long OrderCount;

    @ColumnInfo(name = "shares")
    private long numberOfShares;

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

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
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

    public List<Variants> getVariants() {
        return variants;
    }

    public void setVariants(List<Variants> variants) {
        this.variants = variants;
    }

    public long getTaxId() {
        return taxId;
    }

    public void setTaxId(long taxId) {
        this.taxId = taxId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
}
