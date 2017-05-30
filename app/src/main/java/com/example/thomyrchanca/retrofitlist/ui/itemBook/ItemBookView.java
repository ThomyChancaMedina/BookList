package com.example.thomyrchanca.retrofitlist.ui.itemBook;

import android.widget.ImageView;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;

import java.util.ArrayList;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

public interface ItemBookView {
    void showProgressBar();
    void setItems(ArrayList<Book> items);
    void goToWindons(int pos, Book book, ImageView bookImagen);
    void hideShowProgressBar();
    void showMessage(String message);

}
