package com.example.thomyrchanca.retrofitlist.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

public class Epub {

    @SerializedName("isAvailable")
    @Expose
    public boolean isAvailable;
    @SerializedName("acsTokenLink")
    @Expose
    public String acsTokenLink;

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    @Override
    public String toString() {
        return "Epub{" +
                "isAvailable=" + isAvailable +
                ", acsTokenLink='" + acsTokenLink + '\'' +
                '}';
    }
}
