package com.app.andel.andelsapp;

import android.os.AsyncTask;
import android.os.StrictMode;

import com.apollographql.apollo.ApolloClient;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class MyApolloClient {
    private static final String BASE_URL = "https://www.holdsport.dk/graphql";
    private static ApolloClient MyapolloClient;



    public static ApolloClient getMyapolloClient() throws IOException {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        HttpLoggingInterceptor MyhttpLoggingInterceptor = new HttpLoggingInterceptor();
        MyhttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient MyokHttpClient = new OkHttpClient.Builder().addInterceptor(MyhttpLoggingInterceptor).build();

        Request request = new Request.Builder().url(BASE_URL).header("Authorization","1413868:r4vnxSO0x8mmk8lJ1CQYRQ:157150").build();
        Response response = MyokHttpClient.newCall(request).execute();
        response.body().close();
        MyapolloClient = ApolloClient.builder().serverUrl(BASE_URL).okHttpClient(MyokHttpClient).build();

        return MyapolloClient;
    }
}
