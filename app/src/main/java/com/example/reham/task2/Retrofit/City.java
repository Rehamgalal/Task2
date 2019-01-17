package com.example.reham.task2.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by reham on 1/16/2019.
 */

public class City {
    @SerializedName("Id")
    private int Id;
    @SerializedName("TitleEN")
    private String titleEn;
    @SerializedName("TitleAR")
    private String titleAr;
    @SerializedName("CountryID")
    private int countryId;

    public City(int Id, String titleEn, String titleAr, int countryId) {
        this.Id = Id;
        this.titleEn = titleEn;
        this.titleAr = titleAr;
        this.countryId = countryId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleAr() {
        return titleAr;
    }

    public void setTitleAr(String titleAr) {
        this.titleAr = titleAr;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }
}
