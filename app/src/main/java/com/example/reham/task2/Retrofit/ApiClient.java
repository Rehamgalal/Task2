package com.example.reham.task2.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by reham on 1/16/2019.
 */

public class ApiClient {
    public static final String BASE_URL = "http://souq.hardtask.co/app/app.asmx/";
    private static retrofit2.Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
