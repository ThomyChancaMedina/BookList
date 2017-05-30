package com.example.thomyrchanca.retrofitlist;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;
import com.example.thomyrchanca.retrofitlist.ui.base.BaseActivity;
import com.example.thomyrchanca.retrofitlist.ui.itemBook.ItemBookActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

/**
 * Created by thomyrchanca on 29/05/2017.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.image_only)
    ImageView imageView;

    @BindView(R.id.detail_book)
    TextView detailBook;

    @BindView(R.id.title_book)
    TextView titleBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar();
        supportPostponeEnterTransition();

        Bundle extras = getIntent().getExtras();
        Book books = extras.getParcelable(ItemBookActivity.EXTRA_DESCRIPTION);

        detailBook.setText(books.getDescription());
        titleBook.setText(books.getTitle());


        String imageUrl = books.imageUrl;


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String imageTransitionName = extras.getString(ItemBookActivity.EXTRA_IMAGE);
            imageView.setTransitionName(imageTransitionName);
        }

        Picasso.with(this)
                .load(imageUrl)
                .noFade()
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        supportStartPostponedEnterTransition();
                    }

                    @Override
                    public void onError() {
                        supportStartPostponedEnterTransition();
                    }
                });
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_selection;
    }
}
