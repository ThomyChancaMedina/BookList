package com.example.thomyrchanca.retrofitlist.domain.interactor.book;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;

import java.util.ArrayList;

/**
 * Created by thomyrchanca on 28/05/2017.
 */

public interface GetBookInteractor {
    interface OnBookItemsListener{
        void onBookFinish(ArrayList<Book> items);
    }
    void executeGet(String eventos, OnBookItemsListener listener);
}
