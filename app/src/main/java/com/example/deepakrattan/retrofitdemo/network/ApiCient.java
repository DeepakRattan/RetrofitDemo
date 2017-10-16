package com.example.deepakrattan.retrofitdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by deepak.rattan on 10/16/2017.
 */

public class ApiCient {

    public static final String BASE_URL = "http://navjacinth9.000webhostapp.com/json/";
    private static Retrofit retrofit;

    public static final Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
