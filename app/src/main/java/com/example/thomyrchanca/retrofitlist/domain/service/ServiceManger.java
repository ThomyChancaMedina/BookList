package com.example.thomyrchanca.retrofitlist.domain.service;

import com.example.thomyrchanca.retrofitlist.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by thomyrchanca on 25/05/2017.
 */

public class ServiceManger {

    public static WedService createWebService() {
        Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(BuildConfig.API_ENDPOINT)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

      final WedService mInterfaceServer=retrofit.create(WedService.class);
        return mInterfaceServer;
    }
}

