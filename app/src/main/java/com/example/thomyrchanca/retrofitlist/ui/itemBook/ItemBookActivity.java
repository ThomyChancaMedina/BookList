package com.example.thomyrchanca.retrofitlist.ui.itemBook;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.SearchRecentSuggestions;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.thomyrchanca.retrofitlist.MainActivity;
import com.example.thomyrchanca.retrofitlist.R;
import com.example.thomyrchanca.retrofitlist.domain.entity.Book;
import com.example.thomyrchanca.retrofitlist.ui.base.BaseActivity;
import com.example.thomyrchanca.retrofitlist.ui.itemBook.recycler.Adapter;
import com.example.thomyrchanca.retrofitlist.ui.search.SearchActivity;



import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

public class ItemBookActivity extends BaseActivity implements ItemBookView {

    public static final String EXTRA_DESCRIPTION = "descriction";
    public static final String EXTRA_IMAGE = "image";

    private static final int BOOK_LOADER_ID = 1;

    private String query ;

    private ItemBookPresenterImpl itemBookPresenter;


    @BindView(R.id.rv_book_list)
    RecyclerView rvBooks;


    Adapter adapter;

    ItemBookPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @BindView(R.id.book_progress)
    ProgressBar bookProgress;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar();

        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());


        Bundle extras = getIntent().getExtras();
        String word = extras.getString(SearchActivity.EXTRA_WORD);


       generateBook(word);

       // handleIntent(getIntent());


    }

    public void generateBook(String book){
        presenter = new ItemBookPresenterImpl(this);
        adapter = new Adapter(this, this);

        presenter.getBooks(book);
        rvBooks.setAdapter(adapter);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }


    @Override
    public void showProgressBar() {
        bookProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(ArrayList<Book> items) {
        adapter.setBooks(items);

    }
    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        setIntent(intent);
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if(Intent.ACTION_SEARCH.equals(intent.getAction())){
            query=intent.getStringExtra(SearchManager.QUERY);
         generateBook(query);

        }
    }


/**cambiar el nombre de goToadmin**/
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void goToWindons(int pos, Book bookItems, ImageView bookImagen) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_DESCRIPTION, bookItems);
        intent.putExtra(EXTRA_IMAGE , ViewCompat.getTransitionName(bookImagen));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                bookImagen,
                ViewCompat.getTransitionName(bookImagen));

        startActivity(intent, options.toBundle());
    }

    @Override
    public void hideShowProgressBar() {

        bookProgress.setVisibility(View.GONE);

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
