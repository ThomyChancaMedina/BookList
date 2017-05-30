package com.example.thomyrchanca.retrofitlist.ui.search;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

public interface SearchView {
    void showProgressBar();
    void dismissProgressBar();
    void showMessage(String message);
    void goToBooksActivity(String palabra);
    void disableSignInButton();
    void enableSignInButton();

}
