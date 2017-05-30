package com.example.thomyrchanca.retrofitlist.model;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RetailPrice_ {

    @SerializedName("amountInMicros")
    @Expose
    public float amountInMicros;
    @SerializedName("currencyCode")
    @Expose
    public String currencyCode;

    public float getAmountInMicros() {
        return amountInMicros;
    }

    public void setAmountInMicros(float amountInMicros) {
        this.amountInMicros = amountInMicros;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "RetailPrice_{" +
                "amountInMicros=" + amountInMicros +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}