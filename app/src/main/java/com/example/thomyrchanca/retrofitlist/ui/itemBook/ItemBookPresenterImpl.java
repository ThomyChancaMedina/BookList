package com.example.thomyrchanca.retrofitlist.ui.itemBook;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;
import com.example.thomyrchanca.retrofitlist.domain.interactor.book.GetBookInteractor;
import com.example.thomyrchanca.retrofitlist.domain.interactor.book.GetBookInteractorImpl;
import com.example.thomyrchanca.retrofitlist.ui.search.SearchView;

import java.util.ArrayList;

/**
 * Created by thomyrchanca on 26/05/2017.
 */

public class ItemBookPresenterImpl implements ItemBookPresenter{

    private ItemBookView view;
    private GetBookInteractor getBookInteractor;


    public ItemBookPresenterImpl(ItemBookView view){
        this.view=view;
        getBookInteractor=new GetBookInteractorImpl();

    }



    @Override
    public void getBooks(final String book) {
        if(view!=null){
            view.showProgressBar();
        }

        getBookInteractor.executeGet(book, new GetBookInteractor.OnBookItemsListener() {
            @Override
            public void onBookFinish(ArrayList<Book> items) {
                view.hideShowProgressBar();
                view.setItems(items);

            }
        });



    }


 /*   @Override
    public void onItemClicked(int position) {

    }*/

}
