package com.example.thomyrchanca.retrofitlist.domain.interactor.book;

import android.util.Log;

import com.example.thomyrchanca.retrofitlist.domain.entity.Book;
import com.example.thomyrchanca.retrofitlist.domain.service.ServiceManger;
import com.example.thomyrchanca.retrofitlist.domain.service.WedService;
import com.example.thomyrchanca.retrofitlist.model.Example;
import com.example.thomyrchanca.retrofitlist.model.Items;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by thomyrchanca on 28/05/2017.
 */

public class GetBookInteractorImpl implements GetBookInteractor {
    ArrayList<Book> books = new ArrayList<>();
    private WedService wedService;

    public GetBookInteractorImpl() {
        wedService = ServiceManger.createWebService();
    }

    @Override
    public void executeGet(String eventos, final OnBookItemsListener listener) {

        Map<String, String> data = new HashMap<>();
        data.put("q", eventos);
        Call<Example> call = wedService.getBooks(data);

        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {


                Example users = response.body();

                if (response.body() != null) {


                    List<Items> items = response.body().getItems();

                    String palabra = items.toString();

                    String datos;

                    String[] arrayDatos = palabra.split("VolumeInfo");
                    for (int i = 0; i < arrayDatos.length; i++) {
                        if (i >= 1) {
                            //Log.i("thomy::::", arrayDatos[i]);
                            datos = arrayDatos[i].substring((arrayDatos[i].indexOf("title=")));
                            int posTitle = datos.indexOf("&") + (arrayDatos[i].indexOf("title="));
                            String title = arrayDatos[i].substring((arrayDatos[i].indexOf("title=") + "title=".length()) + 1, posTitle);
                            Log.i("Thomy title ", title);

                            datos = arrayDatos[i].substring((arrayDatos[i].indexOf("authors=")));
                            int posAutor = datos.indexOf("&") + (arrayDatos[i].indexOf("authors="));
                            String author = arrayDatos[i].substring((arrayDatos[i].indexOf("authors=") + "authors=".length()) + 1, posAutor - 1);
                            Log.i("Thomy author ", author);


                            datos = arrayDatos[i].substring((arrayDatos[i].indexOf("description=")));
                            int posDescription = datos.indexOf("&") + (arrayDatos[i].indexOf("description="));
                            String description = arrayDatos[i].substring((arrayDatos[i].indexOf("description=") + "description=".length()) + 1, posDescription - 1);
                            Log.i("thomy::description", description);


                            Log.i("Thomy la repuesta es  ", " " + arrayDatos[i].indexOf("thumbnail="));

                            String thumbnail;

                            if ((arrayDatos[i].indexOf("thumbnail=")) <= -1) {

                                thumbnail = "https://books.google.es/googlebooks/images/no_cover_thumb.gif";


                            } else {
                                datos = arrayDatos[i].substring((arrayDatos[i].indexOf("thumbnail=")));
                                int posImage2 = datos.indexOf("}") + (arrayDatos[i].indexOf("thumbnail="));
                                thumbnail = arrayDatos[i].substring((arrayDatos[i].indexOf("thumbnail=") + "thumbnail=".length()) + 1, posImage2 - 1);

                            }


                            books.add(new Book(title, author, thumbnail, description));

                        }


                    }//for


                    listener.onBookFinish(books);

                }//if null


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });

    }

}
