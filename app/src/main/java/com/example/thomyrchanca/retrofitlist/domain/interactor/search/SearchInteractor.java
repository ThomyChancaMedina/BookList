package com.example.thomyrchanca.retrofitlist.domain.interactor.search;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;

/**
 * Created by thomyrchanca on 28/05/2017.
 */

public interface SearchInteractor {

    interface OnSearchListener {
        void onSuccess(String book);
        void onError(String error);


    }

    void execute(String search, OnSearchListener listener);
}
