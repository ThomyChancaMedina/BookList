package com.example.thomyrchanca.retrofitlist.ui.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.thomyrchanca.retrofitlist.R;
import com.example.thomyrchanca.retrofitlist.ui.base.BaseActivity;
import com.example.thomyrchanca.retrofitlist.ui.itemBook.ItemBookActivity;


import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

public class SearchActivity extends BaseActivity implements SearchView {

    public static final String EXTRA_WORD = "la_palabra";
    SearchPresenter presenter;

    @BindView(R.id.tiet_search)
    TextInputEditText textInputEditText;

    @BindView(R.id.btn_search)
    Button btnSearch;

    @BindView(R.id.pb_search)
    ProgressBar pbSearch;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar();


        presenter = new SearchPresenterImpl(this);




    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_search;
    }

    @OnClick(R.id.btn_search)
    public void searchButtonClicked() {

        presenter.searchButtonClicked(textInputEditText.getText().toString());

    }



    @Override
    public void showProgressBar() {
        pbSearch.setVisibility(View.VISIBLE);

    }

    @Override
    public void dismissProgressBar() {
        pbSearch.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    public void goToBooksActivity(String palabra) {
        Log.i("la palabra",palabra);
        Intent intent = new Intent(this, ItemBookActivity.class);

        intent.putExtra(EXTRA_WORD,palabra);
        startActivity(intent);
    }

    @Override
    public void disableSignInButton() {
        btnSearch.setEnabled(false);
    }

    @Override
    public void enableSignInButton() {
        btnSearch.setEnabled(true);

    }
}
