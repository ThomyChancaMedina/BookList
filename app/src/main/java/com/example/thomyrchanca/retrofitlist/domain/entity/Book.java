package com.example.thomyrchanca.retrofitlist.domain.entity;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

//public class Book extends Object {
public class Book implements Parcelable {

    public String imageUrl;
    private String title;
    private String autor;
    private String description;





    public Book ( String title, String autor ,String imageUrl,String description){
        this.autor=autor;
        this.title=title;
        this.imageUrl=imageUrl;
        this.description=description;




    }

    protected Book(Parcel in) {
        title = in.readString();
        autor = in.readString();
        imageUrl = in.readString();
        description=in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(autor);
        dest.writeString(imageUrl);
        dest.writeString(description);
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
