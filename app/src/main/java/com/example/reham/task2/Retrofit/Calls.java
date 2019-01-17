package com.example.reham.task2.Retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by reham on 1/16/2019.
 */

public class Calls {
    List<String> codes;
    List<String> countriesEn;

    public void countryCall(final Context context, final Spinner code, final Spinner country, final String Lang) {
        Retrofit.ApiInterface apiService = ApiClient.getClient().create(Retrofit.ApiInterface.class);
        Call<List<Country>> call = apiService.getCountries();
        codes = new ArrayList<>();
        countriesEn = new ArrayList<>();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                List<Country> countries = response.body();
                String coden;
                String countryEn = null;
                for (int b = 0; b < countries.size(); b++) {
                    coden = Integer.toString(countries.get(b).getCode());
                    if (Lang.equals("en")) {
                        countryEn = countries.get(b).getTitleEn();
                    } else if (Lang.equals("ar")) {
                        countryEn = countries.get(b).getTitleAr();
                    }
                    countriesEn.add(countryEn);
                    codes.add(coden);
                }
                ArrayAdapter<String> codeAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, codes);
                // Drop down layout style - list view with radio button
                codeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                code.setAdapter(codeAdapter);
                ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, countriesEn);
                countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                country.setAdapter(countryAdapter);
            }


            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
            }
        });
    }

    public void cityCall(final Context context, final Spinner city, int countryId, final String Lang) {
        Retrofit.ApiInterface apiService = ApiClient.getClient().create(Retrofit.ApiInterface.class);
        Call<List<City>> call = apiService.getCities(countryId);

        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                List<String> cities = new ArrayList<>();
                List<City> cityList = response.body();
                if (cityList.size() != 0) {
                    String cityN = null;
                    for (int i = 0; i < cityList.size(); i++) {
                        if (Lang.equals("en")) {
                            cityN = cityList.get(i).getTitleEn();
                        } else if (Lang.equals("ar")) {
                            cityN = cityList.get(i).getTitleAr();
                        }
                        cities.add(cityN);
                    }
                }
                Log.i("cities", "the" + cities);
                ArrayAdapter<String> codeAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, cities);
                // Drop down layout style - list view with radio button
                codeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                // attaching data adapter to spinner
                city.setAdapter(codeAdapter);
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
            }

        });
    }
}
