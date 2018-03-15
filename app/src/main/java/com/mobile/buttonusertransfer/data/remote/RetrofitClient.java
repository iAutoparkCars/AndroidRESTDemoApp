package com.mobile.buttonusertransfer.data.remote;

/**
 * Created by Steven on 3/13/2018.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
    create an instance of Retrofit in the constructor and return the singleton instance to the caller
*/

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}