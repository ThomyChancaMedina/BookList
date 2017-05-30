package com.example.thomyrchanca.retrofitlist.ui.search;

import android.util.Log;


import com.example.thomyrchanca.retrofitlist.domain.interactor.search.SearchInteractor;
import com.example.thomyrchanca.retrofitlist.domain.interactor.search.SearchInteractorImpl;
import com.example.thomyrchanca.retrofitlist.model.Example;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

//Todo:solo este apratado solo sirve para comprobar que esiste la palabra si esta
public class SearchPresenterImpl implements SearchPresenter {
    private SearchView view;

    private SearchInteractor searchInteractor;

    public SearchPresenterImpl(SearchView view) {
        this.view = view;
        searchInteractor = new SearchInteractorImpl();
    }


    @Override
    public void searchButtonClicked(final String search) {
        if (view != null) {
            view.showProgressBar();
            view.disableSignInButton();

        }

        if (areFilledFields(search) ){
            searchInteractor.execute(search, new SearchInteractor.OnSearchListener() {
                @Override
                public void onSuccess(String error) {
                    Log.i("estro al osSuccess", "2");
                    if (view != null) {
                        view.dismissProgressBar();
                        view.enableSignInButton();

                        view.goToBooksActivity(search);


                    }
                }

                @Override
                public void onError(String error) {

                }
            });


        }
    }

    private boolean areFilledFields(String book) {
        if (!book.isEmpty()) {
            return true;
        }
        return false;
    }

}
