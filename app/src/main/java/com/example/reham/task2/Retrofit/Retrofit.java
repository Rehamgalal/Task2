package com.example.reham.task2.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by reham on 1/16/2019.
 */

public interface Retrofit {
    interface ApiInterface {

        @GET("GetCountries")
        Call<List<Country>> getCountries();

        @GET("GetCities")
        Call<List<City>> getCities(@Query("countryId") int id);
    }
}
