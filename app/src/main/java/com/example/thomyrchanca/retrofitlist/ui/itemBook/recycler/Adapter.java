package com.example.thomyrchanca.retrofitlist.ui.itemBook.recycler;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomyrchanca.retrofitlist.R;
import com.example.thomyrchanca.retrofitlist.domain.entity.Book;
import com.example.thomyrchanca.retrofitlist.ui.itemBook.ItemBookView;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by thomyrchanca on 25/05/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private final ItemBookView adaperPresener;
    private ArrayList<Book> books;
    private Context context;

    public Adapter(Context context, ItemBookView adaperPresener) {
        this.context = context;
        books = new ArrayList<>();
        this.adaperPresener = adaperPresener;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_books, parent, false);
        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Book book = books.get(position);

        Picasso.with(holder.itemView.getContext())
                .load(book.imageUrl)
                .tag(context)
                .into(holder.imageView);


        holder.showAuthor.setText(books.get(position).getAutor());
        holder.showTitle.setText(books.get(position).getTitle());


      ViewCompat.setTransitionName(holder.imageView,book.imageUrl);

        holder.imageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                adaperPresener.goToWindons(holder.getAdapterPosition(),book, holder.imageView);

            }
        });


    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.title_text_view)
        TextView showTitle;

        @BindView(R.id.author_text_view)
        TextView showAuthor;

        @BindView(R.id.image_view)
        ImageView imageView;

        Context context;

        public ViewHolder(View view, Context context) {
            super(view);
            ButterKnife.bind(this, view);
            this.context = context;

        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }


}
