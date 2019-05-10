package com.app.andel.andelsapp.Controller;

import com.apollographql.apollo.ApolloClient;

import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApolloClient {
    private static final String BASE_URL = "https://lagdev.com/";
    private static ApolloClient MyapolloClient;

    public static ApolloClient getMyapolloClient(){
        HttpLoggingInterceptor MyhttpLoggingInterceptor = new HttpLoggingInterceptor();
        MyhttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient MyokHttpClient = new OkHttpClient.Builder().addInterceptor(MyhttpLoggingInterceptor).build();

        MyapolloClient = ApolloClient.builder().serverUrl(BASE_URL).okHttpClient(MyokHttpClient).build();

        return MyapolloClient;
    }
}
