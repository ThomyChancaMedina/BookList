package com.example.thomyrchanca.retrofitlist.model;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {

    @SerializedName("finskyOfferType")
    @Expose
    public int finskyOfferType;
    @SerializedName("listPrice")
    @Expose
    public ListPrice_ listPrice;
    @SerializedName("retailPrice")
    @Expose
    public RetailPrice_ retailPrice;
    @SerializedName("giftable")
    @Expose
    public boolean giftable;

    public int getFinskyOfferType() {
        return finskyOfferType;
    }

    public void setFinskyOfferType(int finskyOfferType) {
        this.finskyOfferType = finskyOfferType;
    }

    public ListPrice_ getListPrice() {
        return listPrice;
    }

    public void setListPrice(ListPrice_ listPrice) {
        this.listPrice = listPrice;
    }

    public RetailPrice_ getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(RetailPrice_ retailPrice) {
        this.retailPrice = retailPrice;
    }

    public boolean isGiftable() {
        return giftable;
    }

    public void setGiftable(boolean giftable) {
        this.giftable = giftable;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "finskyOfferType=" + finskyOfferType +
                ", listPrice=" + listPrice +
                ", retailPrice=" + retailPrice +
                ", giftable=" + giftable +
                '}';
    }
}