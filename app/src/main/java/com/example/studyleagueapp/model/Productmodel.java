package com.example.studyleagueapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Productmodel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "categoryName")
    private String categoryName;
    @ColumnInfo(name = "finalPrice")
    private String finalPrice;
    @ColumnInfo(name = "actualPrice")
    private String actualPrice;
    @ColumnInfo(name = "discount")
    private String discount;
    @ColumnInfo(name = "qty")
    private String qty;
    @ColumnInfo(name = "images")
    private String images;

    public Productmodel(int id, String name, String categoryName, String finalPrice, String actualPrice, String discount, String qty, String images) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.finalPrice = finalPrice;
        this.actualPrice = actualPrice;
        this.discount = discount;
        this.qty = qty;
        this.images = images;
    }

    public Productmodel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(String actualPrice) {
        this.actualPrice = actualPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
