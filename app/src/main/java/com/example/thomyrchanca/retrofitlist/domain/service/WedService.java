package com.example.thomyrchanca.retrofitlist.domain.service;

import com.example.thomyrchanca.retrofitlist.model.Example;

import com.example.thomyrchanca.retrofitlist.model.Items;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

public interface WedService {

    @GET("/books/v1/volumes")
    Call<Example> getBooks(@QueryMap Map<String,String> options);
    //Call<Example>getBooks(@Query("q") String eventos);




}
