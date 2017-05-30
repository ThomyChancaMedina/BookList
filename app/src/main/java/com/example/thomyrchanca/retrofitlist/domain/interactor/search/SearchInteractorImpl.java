package com.example.thomyrchanca.retrofitlist.domain.interactor.search;

import android.text.TextUtils;

import com.example.thomyrchanca.retrofitlist.ui.search.SearchPresenterImpl;

/**
 * Created by thomyrchanca on 28/05/2017.
 */

public class SearchInteractorImpl implements SearchInteractor{
    @Override
    public void execute(String search, OnSearchListener listener) {
        boolean error = false;
        if (TextUtils.isEmpty(search)){
            listener.onError("The user not exit Thomy");
            error = true;
            return;
        }
        if (!error){
            listener.onSuccess("libro entro");
        }

    }
}
