package com.example.thomyrchanca.retrofitlist.model;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ReadingModes {

    @SerializedName("text")
    @Expose
    public boolean text;
    @SerializedName("image")
    @Expose
    public boolean image;

    public boolean isText() {
        return text;
    }

    public void setText(boolean text) {
        this.text = text;
    }

    public boolean isImage() {
        return image;
    }

    public void setImage(boolean image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ReadingModes{" +
                "text=" + text +
                ", image=" + image +
                '}';
    }
}
